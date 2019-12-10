package com.brian.egreenhouse.web.rest;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.service.ChannelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChannelController {

    public static final String BASE_PATH = "/egreenhouse";

    public final ChannelService service;

    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @GetMapping(BASE_PATH + "/feeds")
    public Mono<Channel> getFeeds() {
        return service.findAllFeeds();
    }

    @GetMapping(BASE_PATH + "/feedsbydate")
    public Mono<Channel> getFeedsByDate(@RequestParam String startDate,
                                     @RequestParam String endDate){

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTimeStartDate = LocalDateTime.parse(startDate, formatter);
        LocalDateTime dateTimeEndDate = LocalDateTime.parse(endDate, formatter);

        return  service.findFeedsByDate(dateTimeStartDate,dateTimeEndDate);

    }

}
