package com.one.two.SongService.dao;

import com.one.two.SongService.domain.SongMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongMetadataRepository extends JpaRepository<SongMetadata, Integer > {
}
