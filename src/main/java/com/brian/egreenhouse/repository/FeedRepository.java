package com.brian.egreenhouse.repository;

import com.brian.egreenhouse.domain.Feed;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FeedRepository extends ReactiveCrudRepository<Feed, String> {

    @Tailable
    Flux<Feed> findWithTailableCursorBy();
}
