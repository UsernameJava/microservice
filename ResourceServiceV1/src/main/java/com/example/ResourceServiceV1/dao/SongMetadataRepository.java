package com.example.ResourceServiceV1.dao;

import com.example.ResourceServiceV1.domain.SongMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongMetadataRepository extends JpaRepository<SongMetadata, Integer > {
}
