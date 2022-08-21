package com.one.two.SongService.controller;

import com.one.two.SongService.domain.SongMetadata;
import com.one.two.SongService.service.SongMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class SongMetadataController {
    private static final Logger LOGGER = Logger.getLogger(SongMetadataController.class.getName());
    @Autowired
    SongMetadataService songMetadataService;

    @PostMapping("/songs")
    public Map<String,Object> saveSongMetadata(@RequestBody SongMetadata songMetadata){
        LOGGER.info("Recieved Song metadata request:" + songMetadata);
        Map<String,Object> result = new HashMap<>();
        result.put("id", songMetadataService.addSongMetadata(songMetadata));
        return result;
    }

    @GetMapping("/songs/{id}")
    public SongMetadata getSongMetadataById(@PathVariable int id){
        return songMetadataService.getSongMetadataById(id);
    }

    @DeleteMapping("/songs")
    public Map<String,Object> deleteSongMetadataByIds(@RequestParam List<Integer> ids){
        Map<String,Object> result = new HashMap<>();
        result.put("ids", songMetadataService.deleteSongMetadatas(ids));
        return result;
    }
}
