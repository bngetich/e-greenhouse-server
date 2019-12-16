package com.brian.egreenhouse.service;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    private static final int CHANNEL_ID = 554640;
    private static final Logger log = LoggerFactory.getLogger(ChannelService.class);

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public Mono<Channel> findChannel() {
        return channelRepository.findById(CHANNEL_ID);
    }

    public Mono<Void> updateChannel(Channel channel){
        return channelRepository.save(channel).then();
    }



}
