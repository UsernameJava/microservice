package com.one.two.SongService.service;

import com.one.two.SongService.domain.SongMetadata;

import java.util.List;

public interface SongMetadataService {
    int addSongMetadata(SongMetadata songMetadata);
    SongMetadata getSongMetadataById(Integer id);
    List<Integer> deleteSongMetadatas(List<Integer> songMetadataIds);
}
