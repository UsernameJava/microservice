package com.one.two.ResourceProcessor.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials =
                new BasicAWSCredentials("accessKey", "secretKey");
        AwsClientBuilder.EndpointConfiguration config =
                new AwsClientBuilder.EndpointConfiguration("http://localstack:4566", "ap-south-1");

        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(config)
                .withPathStyleAccessEnabled(true)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}