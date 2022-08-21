package com.one.two.SongService.service;

import com.one.two.SongService.dao.SongMetadataRepository;
import com.one.two.SongService.domain.SongMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongMetadataServiceImpl implements SongMetadataService{
    @Autowired
    SongMetadataRepository songMetadataRepository;

    @Override
    public int addSongMetadata(SongMetadata songMetadata) {
        SongMetadata created = songMetadataRepository.saveAndFlush(songMetadata);
        return created.getId();
    }

    @Override
    public SongMetadata getSongMetadataById(Integer id) {
        return songMetadataRepository.findById(id).get();
    }

    @Override
    public List<Integer> deleteSongMetadatas(List<Integer> songMetadataIds) {
        songMetadataRepository.deleteAllByIdInBatch(songMetadataIds);
        return songMetadataIds;
    }
}
