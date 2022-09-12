package com.deft;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class RestControllerExample {

    private Log log = LogFactory.getLog(RestControllerExample.class);


    @GetMapping(value = "/tweets-non-blocking",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> getTweetsNonBlocking() {
        log.info("Starting NON-BLOCKING Controller!");
        Flux<Tweet> tweetFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080/slow-service-tweets")
                .retrieve()
                .bodyToFlux(Tweet.class);

        tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
        log.info("Exiting NON-BLOCKING Controller!");
        return tweetFlux;
    }
}
