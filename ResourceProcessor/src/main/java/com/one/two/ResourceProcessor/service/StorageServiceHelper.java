package com.one.two.ResourceProcessor.service;

import com.one.two.ResourceProcessor.domain.StorageDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class StorageServiceHelper {

    private static final Logger LOGGER = Logger.getLogger(StorageServiceHelper.class.getName());
    @Autowired
    @Qualifier("storageservice")
    private WebClient webClient;

    @CircuitBreaker(name = "circuitBreaker", fallbackMethod="fallbackGetStoragesFromStorageService")
    public List<StorageDto> getStoragesFromStorageService() {
        return webClient.get()
                .uri("storages")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<StorageDto>>() {})
                .block();
    }

    public List<StorageDto> fallbackGetStoragesFromStorageService(Throwable t) {
        StorageDto storageDto = new StorageDto();
        storageDto.setStorageType("PERMANENT");
        storageDto.setBucket("fallbackstorage");
        LOGGER.info("It was called fallback method for choosing storage");
        return Arrays.asList(storageDto);
    }
}
