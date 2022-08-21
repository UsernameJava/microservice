package com.example.ResourceServiceV1.publisher;

import com.example.ResourceServiceV1.domain.SongMetadata;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public abstract class TestBase {
    @Autowired
    ResourcePublisher resourcePublisher;

    protected void testSendEvent() {
        SongMetadata songMetadata = new SongMetadata();
        songMetadata.setId(1);
        songMetadata.setName("Die Antwort");
        resourcePublisher.sendEvent(songMetadata);
    }
}
