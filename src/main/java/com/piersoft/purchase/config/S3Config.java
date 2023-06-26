package com.piersoft.purchase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Bean
    public S3Client s3Client(){
        return S3Client.builder()
                .credentialsProvider(amazonAwsCredentials())
                .region(Region.AP_SOUTH_1)
                .build();
    }

    public AwsCredentialsProvider amazonAwsCredentials() {
        return StaticCredentialsProvider.create(AwsBasicCredentials.create(
                "AKIAUXE3DRY2CKCGAF6J", "usNHutBMUKe9NF3QF4Qk13WpvWBzCdSSM8jtyADb"));
    }
}
