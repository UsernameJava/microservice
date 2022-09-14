package com.example.ResourceServiceV1.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "resource_service_song_metadata")
public class SongMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "traceid")
    private String traceId;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album")
    private String album;

    @Column(name = "length")
    private String length;

    @Column(name = "year")
    private String year;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "status")
    private String status;

    //@Column(name = "resourceId")
    @Transient
    private String resourceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFileName() {
        return fileName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongMetadata that = (SongMetadata) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(traceId, that.traceId) && Objects.equals(artist, that.artist) && Objects.equals(album, that.album) && Objects.equals(length, that.length) && Objects.equals(year, that.year) && Objects.equals(fileName, that.fileName) && Objects.equals(status, that.status) && Objects.equals(resourceId, that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, traceId, artist, album, length, year, fileName, status, resourceId);
    }

    @Override
    public String toString() {
        return "SongMetadata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", traceId='" + traceId + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", length='" + length + '\'' +
                ", year='" + year + '\'' +
                ", fileName='" + fileName + '\'' +
                ", status='" + status + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
