package com.piersoft.purchase.controller;


import com.piersoft.purchase.api.request.dto.CreateASNDTO;
import com.piersoft.purchase.api.request.mapper.CreateASNMapper;
import com.piersoft.purchase.persistence.entities.ASN;
import com.piersoft.purchase.service.ASNService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/purchase/asn")
public class ASNController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ASNController.class);

    @Autowired
    private CreateASNMapper createASNMapper;

    @Autowired
    private ASNService asnService;

    // API to create an ASN
    @ApiOperation(value = "creates an asn", notes = "returns public url of the QR code", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully creates an asn"),
            @ApiResponse(code = 404, message = "Not found - asn creation fails")
    })
    @PostMapping(value = "/create-asn")
    public ResponseEntity<String> createASN(@RequestBody CreateASNDTO createASNDTO){
        ASN asn = createASNMapper.toEntity(createASNDTO);
        return ResponseEntity.ok(asnService.createASN(asn));
    }

    // get asn details by asn id
    @ApiOperation(value = "get asn details by asn id", notes = "returns asn details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully gets asn details"),
            @ApiResponse(code = 404, message = "Not found - asn details not found")
    })
    @GetMapping(value = "/get-asn-details/{asnId}")
    public ResponseEntity<ASN> getASNDetails(@PathVariable Long asnId){
        return ResponseEntity.ok(asnService.getASNDetails(asnId));
    }
}
