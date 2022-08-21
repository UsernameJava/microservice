package com.one.two.SongService.service;

import com.one.two.SongService.dao.SongMetadataRepository;
import com.one.two.SongService.domain.SongMetadata;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class SongMetadataServiceImplTests {

    @InjectMocks
    private SongMetadataServiceImpl songMetadataService;

    @Mock
    private SongMetadataRepository songMetadataRepository;

    @Test
    public void testAddSongMetadata() {
        //Arrange
        SongMetadata created = new SongMetadata();
        created.setId(1);
        when(songMetadataRepository.saveAndFlush(created)).thenReturn(created);
        //Act
        int result = songMetadataService.addSongMetadata(created);
        //Assert
        assertThat(result).isEqualTo(1);
    }
}
