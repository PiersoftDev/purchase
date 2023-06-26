package com.piersoft.purchase.service.impl;

import com.piersoft.purchase.persistence.entities.ASN;
import com.piersoft.purchase.persistence.repositories.ASNRepository;
import com.piersoft.purchase.service.ASNService;
import com.piersoft.purchase.util.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectAclResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class ASNServiceImpl implements ASNService {

    @Autowired
    private ASNRepository asnRepository;

    @Autowired
    private QRCodeGenerator qrCodeGenerator;

    @Autowired
    private S3Client s3Client;

    @Override
    public String createASN(ASN asn) {
        asn = asnRepository.save(asn);
        try {
            BufferedImage qrImage = qrCodeGenerator.generateEAN13BarcodeImage(Long.toString(asn.getId()));
            return uploadImageToS3("converse-artifacts", Long.toString(asn.getId()), qrImage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ASN getASNDetails(Long asnId) {
        return asnRepository.findById(asnId).get();
    }

    private String uploadImageToS3(String bucketName, String originalFileName, BufferedImage qrImage) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //ImageIO.write(qrImage, "png", os);

        BufferedImage overly = ImageIO.read(this.getClass().getResourceAsStream("/logo.png"));//ImageIO.read(new File("C:\\Users\\91994\\Downloads\\logo.png"));
        int deltaHeight = qrImage.getHeight() - overly.getHeight();
        int deltaWidth = qrImage.getWidth() - overly.getWidth();

        // Initialize combined image
        BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) combined.getGraphics();

        // Write QR code to new image at position 0/0
        g.drawImage(qrImage, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // Write logo into combine image at position (deltaWidth / 2) and
        // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
        // the same space for the logo to be centered
        g.drawImage(overly, (deltaWidth / 2),(deltaHeight / 2), null);

        // Write combined image as PNG to OutputStream
        ImageIO.write(combined, "png", os);
        // Store Image

        byte[] buffer = os.toByteArray();
        InputStream is = new ByteArrayInputStream(buffer);


        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(originalFileName+".png")
                .acl("public-read")
                .build();
        PutObjectResponse response = s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(is, buffer.length));
        System.out.println(response);
        String publicUrl = "https://converse-artifacts.s3.ap-south-1.amazonaws.com/"+originalFileName+".png";
return publicUrl;




    }
}
