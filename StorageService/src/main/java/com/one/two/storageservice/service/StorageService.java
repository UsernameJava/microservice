package com.one.two.storageservice.service;

import com.one.two.storageservice.domain.StorageDto;

import java.util.List;

public interface StorageService {

    int addStorageDto(StorageDto storageDto);
    StorageDto getStorageDtoById(Integer id);
    List<Integer> deleteStorageDtos(List<Integer> storageDtoIds);
    List<StorageDto> getStorageDtos();
}
