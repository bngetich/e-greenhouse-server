package com.brian.egreenhouse.repository;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.domain.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public class ChannelDAO {

    @Autowired
    public ReactiveMongoTemplate reactiveTemplate;

    private static final Logger log = LoggerFactory.getLogger(ChannelDAO.class);


    public Mono<Channel> addFeed(Feed feed, int channelId) {
        return reactiveTemplate.findOne(
                new Query(Criteria.where("id").is(channelId)), Channel.class)
                .flatMap(channel -> {
                    if (channel != null) {
                        channel.getFeeds().add(feed);
                    }
                    return reactiveTemplate.save(channel);
                });
    }

    public Mono<Channel> findFeedsByDate(LocalDateTime startDate,
                                         LocalDateTime endDate,
                                         int channelID) {
        return reactiveTemplate.findOne(
                new Query(
                        Criteria.where("id").is(channelID).andOperator(
                                Criteria.where("feeds.created_at").gte(startDate).lte(endDate))
                ), Channel.class);
    }
}
