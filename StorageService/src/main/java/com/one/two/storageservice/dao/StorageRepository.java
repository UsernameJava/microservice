package com.one.two.storageservice.dao;

import com.one.two.storageservice.domain.StorageDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<StorageDto, Integer >  {
}
