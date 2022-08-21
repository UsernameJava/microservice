package com.example.ResourceServiceV1.util;

import com.example.ResourceServiceV1.controller.ResourceServiceController;
import com.example.ResourceServiceV1.domain.SongMetadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public final class SongMetadataConverter {

    private static final Logger LOGGER = Logger.getLogger(SongMetadataConverter.class.getName());
    public static SongMetadata convertJson(String json)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SongMetadata songMetadata = objectMapper.readValue(json, SongMetadata.class);
            return songMetadata;
        } catch (JsonProcessingException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
