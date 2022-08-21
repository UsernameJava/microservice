package com.example.ResourceServiceV1.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ResourceServiceImpl implements ResourceService {
    private AmazonS3 amazonS3;
    @Override
    public String saveFile(String path, String fileName, Optional<Map<String, String>> optionalMetaData, InputStream inputStream) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(objectMetadata::addUserMetadata);
            }
        });
        String keyForFileInS3Bucket = UUID.randomUUID().toString();
        try {
            amazonS3.putObject(path, keyForFileInS3Bucket, inputStream, objectMetadata);
        } catch (AmazonServiceException e) {
            throw new IllegalStateException("Failed to upload the file", e);
        }
        //return fileName.substring(0, fileName.indexOf(".mp3"));
        return keyForFileInS3Bucket;
    }

    @Override
    public byte[] downloadFile(String path, String key) {
        try {
            S3Object object = amazonS3.getObject(path, key);
            S3ObjectInputStream objectContent = object.getObjectContent();
            return IOUtils.toByteArray(objectContent);
        } catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download the file", e);
        }
    }

    @Override
    public List<String> deleteFiles(List<String> ids, String bucketName) {

        for (String id : ids){
            amazonS3.deleteObject(new DeleteObjectRequest(bucketName, id + ".mp3"));
        }
        return ids;
    }


}
