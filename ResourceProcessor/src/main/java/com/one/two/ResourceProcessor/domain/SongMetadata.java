package com.one.two.ResourceProcessor.domain;

import java.util.Objects;

public class SongMetadata {
    private int id;
    private String name;
    private String artist;
    private String album;
    private String length;
    private String resourceId;
    private String year;

    private String traceId;

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
        return id == that.id && name.equals(that.name) && artist.equals(that.artist) && album.equals(that.album) && length.equals(that.length) && resourceId.equals(that.resourceId) && year.equals(that.year) && traceId.equals(that.traceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist, album, length, resourceId, year, traceId);
    }

    @Override
    public String toString() {
        return "SongMetadata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", length='" + length + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", year='" + year + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
