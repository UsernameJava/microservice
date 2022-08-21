package com.example.ResourceServiceV1.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ResourceService {
    String saveFile(String path,
                 String fileName,
                 Optional<Map<String, String>> optionalMetaData,
                 InputStream inputStream);
    byte[] downloadFile(String path, String key);

    List<String> deleteFiles(List<String> ids, String bucketName);
}
