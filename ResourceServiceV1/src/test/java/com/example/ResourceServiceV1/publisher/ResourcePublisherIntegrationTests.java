package com.example.ResourceServiceV1.publisher;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;

import lombok.val;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = ResourcePublisherIntegrationTests.Initializer.class)
public class ResourcePublisherIntegrationTests {
    @ClassRule
    public static GenericContainer rabbit = new GenericContainer("rabbitmq:3.10-management")
            .withExposedPorts(5672, 15672);
    @Rule
    public OutputCaptureRule outputCapture = new OutputCaptureRule();

    @Autowired
    private ResourcePublisher resourcePublisher;

    @Test
    public void testSendEvent() {
        resourcePublisher.sendEvent("Broadcast Test");
        await().atMost(5, TimeUnit.SECONDS).until(isMessagePublished(), is(false));
    }

    private Callable<Boolean> isMessagePublished() {
        return () -> outputCapture.toString().contains("Broadcast Test");
    }


    public static class Initializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            val values = TestPropertyValues.of(
                    "spring.rabbitmq.host=" + rabbit.getContainerIpAddress(),
                    "spring.rabbitmq.port=" + rabbit.getMappedPort(5672)
            );
            values.applyTo(configurableApplicationContext);
        }
    }
}
