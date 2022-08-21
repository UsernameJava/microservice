package com.one.two.SongService.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song_metadata")
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

    @Column(name = "resourceId")
    private String resourceId;

    @Column(name = "year")
    private String year;

    @Column(name = "filename")
    private String fileName;

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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongMetadata that = (SongMetadata) o;
        return id == that.id && name.equals(that.name) && traceId.equals(that.traceId) && artist.equals(that.artist) && album.equals(that.album) && length.equals(that.length) && resourceId.equals(that.resourceId) && year.equals(that.year) && fileName.equals(that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, traceId, artist, album, length, resourceId, year, fileName);
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
                ", resourceId='" + resourceId + '\'' +
                ", year='" + year + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
