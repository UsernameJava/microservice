package com.example.ResourceServiceV1.service;

import com.example.ResourceServiceV1.dao.SongMetadataRepository;
import com.example.ResourceServiceV1.domain.SongMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ResourceMetadataServiceImpl implements ResourceMetadataService{
    private static final Logger LOGGER = Logger.getLogger(ResourceMetadataServiceImpl.class.getName());
    @Autowired
    private SongMetadataRepository songMetadataRepository;
    @Override
    public int addSongMetadata(SongMetadata songMetadata) {
        SongMetadata created = songMetadataRepository.saveAndFlush(songMetadata);
        LOGGER.info("Saved Song Metadata in Resource Service:" + created);
        return created.getId();
    }
}
