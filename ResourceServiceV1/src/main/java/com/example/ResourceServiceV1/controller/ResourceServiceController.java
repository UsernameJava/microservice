package com.example.ResourceServiceV1.controller;

import com.example.ResourceServiceV1.domain.SongMetadata;
import com.example.ResourceServiceV1.publisher.ResourcePublisher;
import com.example.ResourceServiceV1.service.ResourceMetadataService;
import com.example.ResourceServiceV1.service.ResourceMetadataServiceImpl;
import com.example.ResourceServiceV1.service.ResourceService;
import com.example.ResourceServiceV1.service.StorageService;
import com.example.ResourceServiceV1.util.SongMetadataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@RestController
public class ResourceServiceController {

    private static final Logger LOGGER = Logger.getLogger(ResourceServiceController.class.getName());
    private static final String MP_3_EXTENSION = ".mp3";
    @Autowired
    ResourceService resourceService;
    @Autowired
    ResourcePublisher resourcePublisher;
    @Autowired
    ResourceMetadataService resourceMetadataService;
    @Autowired
    StorageService storageService;

    @PostMapping(path = "/resources",
            consumes = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.MULTIPART_FORM_DATA_VALUE })
    public Map<String, Object> saveResource(@RequestPart("file") MultipartFile file,
                                            @RequestPart("songMetadata") String songMetadataJson,
                                            @RequestHeader(value = "traceId", required = false) String traceId) {
        LOGGER.info("Received song metadata:" + songMetadataJson);
        LOGGER.info("Received trace id:" + traceId);
        Map<String, Object> response = new HashMap<>();
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String fileName = file.getOriginalFilename();
        SongMetadata songMetadata = SongMetadataConverter.convertJson(songMetadataJson);
        songMetadata.setFileName(fileName);
        songMetadata.setLength(String.valueOf(file.getSize()));
        songMetadata.setTraceId(traceId);
        resourceMetadataService.addSongMetadata(songMetadata);
        String result = "0";
        try {
            result = resourceService.saveFile(storageService.extractStagingBucketName(), fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response.put("id", result);
        songMetadata.setResourceId(result);

        try {
            resourcePublisher.sendEvent(songMetadata);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @GetMapping("/resources/{id}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getSongFromBucket(@PathVariable("id") String id) {
        byte[] file = resourceService.downloadFile(storageService.extractStagingBucketName(), id);
        ByteArrayResource resource = new ByteArrayResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + id + MP_3_EXTENSION)
                //.contentType(MediaType.) //
                .contentLength(file.length) //
                .body(resource);
    }

    @DeleteMapping("/resources")
    public ResponseEntity<Map<String, Object>> deleteFiles(@RequestParam List<String> ids) {
        List<String> result = resourceService.deleteFiles(ids, storageService.extractStagingBucketName());
        Map<String, Object> response = new HashMap<>();
        response.put("ids", result);
        return ResponseEntity.ok()
                .body(response);
    }
}
