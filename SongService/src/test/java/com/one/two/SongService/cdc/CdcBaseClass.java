package com.one.two.SongService.cdc;

import com.one.two.SongService.SongServiceApplication;
import com.one.two.SongService.controller.SongMetadataController;
import com.one.two.SongService.domain.SongMetadata;
import com.one.two.SongService.service.SongMetadataService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = SongServiceApplication.class)
public class CdcBaseClass {
    @Autowired
    SongMetadataController songMetadataController;
    @MockBean
    SongMetadataService songMetadataService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(songMetadataController);
        SongMetadata songMetadata = new SongMetadata();
        songMetadata.setId(1);
        songMetadata.setArtist("Die Antwort");
        songMetadata.setName("Name");
        songMetadata.setAlbum("Gamer");
        songMetadata.setYear("2009");
        when(songMetadataService.getSongMetadataById(1))
                .thenReturn(songMetadata);
    }
}
