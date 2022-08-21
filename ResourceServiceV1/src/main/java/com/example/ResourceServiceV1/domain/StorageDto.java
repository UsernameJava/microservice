package com.example.ResourceServiceV1.domain;

import javax.persistence.*;
import java.util.Objects;

public class StorageDto {
    private int id;
    private String storageType;
    private String bucket;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageDto that = (StorageDto) o;
        return id == that.id && Objects.equals(storageType, that.storageType) && Objects.equals(bucket, that.bucket) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storageType, bucket, path);
    }
}
