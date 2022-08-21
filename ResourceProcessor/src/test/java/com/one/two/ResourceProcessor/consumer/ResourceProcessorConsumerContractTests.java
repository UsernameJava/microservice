package com.one.two.ResourceProcessor.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.example:ResourceServiceV1:+"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ResourceProcessorConsumerContractTests {
    @Autowired
    StubTrigger stubTrigger;
    @Test
    public void testSendEvent() {
        stubTrigger.trigger("song-metadata");

    }
}
