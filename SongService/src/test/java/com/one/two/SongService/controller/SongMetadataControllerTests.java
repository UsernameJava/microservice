package com.one.two.SongService.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-songmetadata-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-songmetadata-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class SongMetadataControllerTests {
    @Autowired
    private SongMetadataController songMetadataController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSongMetadataByIdTest() throws Exception {
        this.mockMvc.perform(get("/songs/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Song Name\",\"artist\":\"Artist\",\"album\":\"Albub\",\"length\":\"2:38\",\"resourceId\":\"asdwe23\",\"year\":\"2010\",\"fileName\":\"qwer.mp3\"}"));
    }

    @Test
    public void deleteSongMetadataByIdsTest() throws Exception {
        this.mockMvc.perform(delete("/songs").param("ids", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{ids=[1]}"));
    }

    @Test
    public void saveSongMetadataTest() throws Exception {
        this.mockMvc.perform(post("/songs").content("{\"name\":\"DieAntwort\", \"resourceId\":\"abc\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":")));
    }
}
