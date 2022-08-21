package com.example.ResourceServiceV1.service;

import com.example.ResourceServiceV1.domain.StorageDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private static final Logger LOGGER = Logger.getLogger(StorageService.class.getSimpleName());
    @Autowired
    private StorageServiceHelper storageServiceHelper;

    public String extractStagingBucketName() {
        try {
            List<StorageDto> response = storageServiceHelper.getStoragesFromStorageService();
            LOGGER.info("All storages from StorageService:" + response);

            List<StorageDto> stagingBuckets = response.stream()
                    .filter(storageDto -> "STAGING".equals(storageDto.getStorageType()))
                    .filter(storageDto -> Objects.nonNull(storageDto.getBucket()))
                    .collect(Collectors.toList());

            Random rand = new Random();
            String stagingBucketName =  stagingBuckets.get(rand.nextInt(stagingBuckets.size())).getBucket();
            LOGGER.info("Selected Staging bucket name: " + stagingBucketName);
            return stagingBucketName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
