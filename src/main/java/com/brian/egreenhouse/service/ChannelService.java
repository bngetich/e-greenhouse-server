package com.brian.egreenhouse.service;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.domain.Feed;
import com.brian.egreenhouse.repository.ChannelDAO;
import com.brian.egreenhouse.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ChannelService {

    @Autowired
    ReactiveMongoOperations reactiveTemplate;

    private final ChannelRepository channelRepository;
    private final ChannelDAO channelDAO;

    private static final int CHANNEL_ID = 554640;
    private static final Logger log = LoggerFactory.getLogger(ChannelService.class);

    public ChannelService(ChannelRepository channelRepository,
                          ChannelDAO channelDAO) {
        this.channelRepository = channelRepository;
        this.channelDAO = channelDAO;
    }

    public Mono<Void> addFeed(Feed feed) {
        return channelDAO.addFeed(feed, CHANNEL_ID).then();
    }

    public Mono<Channel> findAllFeeds() {
        return channelRepository.findById(CHANNEL_ID);
    }

    public Mono<Channel> findFeedsByDate(LocalDateTime startDate, LocalDateTime endDate){
        return channelDAO.findFeedsByDate(startDate, endDate, CHANNEL_ID);
    }

}
