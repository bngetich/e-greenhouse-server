package com.brian.egreenhouse.repository;

import com.brian.egreenhouse.domain.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalTime;

@Repository
public class FeedDAO {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;


    public Flux<Feed> findAllFeedsWithTailableCursor(){
        return reactiveMongoTemplate.tail(new Query(Criteria.where("created_at")), Feed.class);
    }

    public Flux<Feed> findFeedsByTimeWithTailableCursor(LocalTime startTime, LocalTime endTime){
        return reactiveMongoTemplate.tail(
                new Query(Criteria.where("created_at").gte(startTime).lte(endTime)), Feed.class);
    }



}
