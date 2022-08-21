package com.one.two.storageservice.service;

import com.one.two.storageservice.dao.StorageRepository;
import com.one.two.storageservice.domain.StorageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    private StorageRepository storageRepository;

    @Override
    public int addStorageDto(StorageDto storageDto) {
        StorageDto created = storageRepository.saveAndFlush(storageDto);
        return created.getId();
    }

    @Override
    public StorageDto getStorageDtoById(Integer id) {
        return storageRepository.findById(id).get();
    }

    @Override
    public List<Integer> deleteStorageDtos(List<Integer> storageDtoIds) {
        storageRepository.deleteAllByIdInBatch(storageDtoIds);
        return storageDtoIds;
    }

    @Override
    public List<StorageDto> getStorageDtos() {
        return storageRepository.findAll();
    }
}
