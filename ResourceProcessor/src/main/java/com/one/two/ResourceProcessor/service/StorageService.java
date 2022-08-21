package com.one.two.ResourceProcessor.service;

import com.one.two.ResourceProcessor.domain.StorageDto;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private static final Logger LOGGER = Logger.getLogger(StorageService.class.getSimpleName());

    @Autowired
    private StorageServiceHelper storageServiceHelper;

    public String extractPermanentBucketName() {
        List<StorageDto> response = storageServiceHelper.getStoragesFromStorageService();
        LOGGER.info("All storages from StorageService:" + response);

        List<StorageDto> permanentBuckets = response.stream()
                .filter(storageDto -> "PERMANENT".equals(storageDto.getStorageType()))
                .filter(storageDto -> Objects.nonNull(storageDto.getBucket()))
                .collect(Collectors.toList());

        Random rand = new Random();
        int randomBucketIndex = rand.nextInt(permanentBuckets.size());
        String permanentBucketName =  permanentBuckets.get(0).getBucket();
        LOGGER.info("Selected Permanent bucket name: " + permanentBucketName);
        return permanentBucketName;
    }
}
