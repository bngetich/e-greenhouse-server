package com.brian.egreenhouse.web.rest;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.service.ChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ChannelController {

    public static final String BASE_PATH = "/egreenhouse/channel";

    public final ChannelService service;

    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @GetMapping(BASE_PATH + "/save")
    public Mono<Void> updateChannel(
            @RequestBody Channel channel) {

        return this.service.updateChannel(channel);
    }


}
