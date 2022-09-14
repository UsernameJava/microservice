package com.one.two.ResourceProcessor.consumer;

import com.amazonaws.services.s3.AmazonS3;
import com.one.two.ResourceProcessor.config.MessagingConfig;
import com.one.two.ResourceProcessor.domain.SongMetadata;
import com.one.two.ResourceProcessor.service.StorageService;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.logging.Logger;

@Component
public class ResourceProcessorConsumer {

    private static final String SONGS = "/songs";
    private static final Logger LOGGER = Logger.getLogger(ResourceProcessorConsumer.class.getName());
    private static final String ID_KEY = "id";
    @Autowired
    @Qualifier("songservice")
    private WebClient songServiceWebClient;

    @Autowired
    @Qualifier("resourceservice")
    private WebClient resourceServiceWebClient;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired (required = false)
    private RetryRegistry registry;

    @RabbitListener(queues = "resourceservice_queue")
    @Retry(name = "consumeMessageFromQueue")
    @Transactional
    public void consumeMessageFromQueue(SongMetadata songMetadata) throws Exception {
        LOGGER.info("Message received from queue:" + songMetadata);

        //get file from the resource service by resource id
        ByteArrayResource response = resourceServiceWebClient.get()
                .uri("resources/" + songMetadata.getResourceId())
                .retrieve()
                .bodyToMono(ByteArrayResource.class)
                .block();

        // save file to PERMANENT s3 bucket
        String permanentBucketName = storageService.extractPermanentBucketName();
        LOGGER.info("Permanent Bucket Name:" + permanentBucketName);
        amazonS3.putObject(permanentBucketName, UUID.randomUUID().toString(), response.getInputStream(), null);

        songMetadata.setId(0);
        songMetadata.setStatus("File saved in permanent bucket with name:" + permanentBucketName);
        sendDataToSongService(songMetadata);
    }

    //@Retry(name = "sendDataToSongService")
    public void sendDataToSongService(SongMetadata songMetadata){
        try {
            String response = songServiceWebClient.post()
                    .uri(SONGS)
                    .body(Mono.just(songMetadata), SongMetadata.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            LOGGER.info("Response from SongService:" + response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //@PostConstruct
    public void postConstruct() {
        registry
                .retry("consumeMessageFromQueue")
                .getEventPublisher()
                .onRetry(x -> LOGGER.info("Retry info:" + x));
        registry
                .retry("sendDataToSongService")
                .getEventPublisher()
                .onRetry(x -> LOGGER.info("Retry info:" + x));
    }
}
