package com.one.two.storageservice.controller;

import com.one.two.storageservice.domain.StorageDto;
import com.one.two.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StorageServiceController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storages/{id}")
    public StorageDto getSongMetadataById(@PathVariable int id) {
        return storageService.getStorageDtoById(id);
    }

    @GetMapping("/storages")
    public List<StorageDto> getSongMetadataById() {
        return storageService.getStorageDtos();
    }

    @PostMapping("/storages")
    public Map<String,Object> saveStorageDto(@RequestBody StorageDto storageDto) {
        Map<String,Object> result = new HashMap<>();
        result.put("id", storageService.addStorageDto(storageDto));
        return result;
    }

    @DeleteMapping("/storages")
    public Map<String,Object> deleteStorageDtoByIds(@RequestParam List<Integer> ids){
        Map<String,Object> result = new HashMap<>();
        result.put("ids", storageService.deleteStorageDtos(ids));
        return result;
    }
}
