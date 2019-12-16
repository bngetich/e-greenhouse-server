package com.brian.egreenhouse.web.rest;

import com.brian.egreenhouse.domain.Feed;
import com.brian.egreenhouse.service.FeedService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FeedController {

    public static final String BASE_PATH = "/egreenhouse/feeds";

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping(value = BASE_PATH, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Feed> getFeedsByTailing() {
        return feedService.getAllByTailing().delayElements(Duration.ofSeconds(1));
    }

}
