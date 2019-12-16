package com.brian.egreenhouse.service;

import com.brian.egreenhouse.domain.Feed;
import com.brian.egreenhouse.repository.FeedDAO;
import com.brian.egreenhouse.repository.FeedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class FeedService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final FeedDAO feedDAO;
    private final FeedRepository repository;

    private static final Logger log = LoggerFactory.getLogger(FeedService.class);


    public FeedService(ReactiveMongoTemplate reactiveMongoTemplate, FeedDAO feedDAO, FeedRepository repository) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.feedDAO = feedDAO;
        this.repository = repository;
    }

    @PostConstruct
    void configure() {
        reactiveMongoTemplate.dropCollection("feed")
                .then(
                        reactiveMongoTemplate.createCollection("feed",
                                CollectionOptions.empty().capped().size(4096).maxDocuments(1440))
                ).subscribe();
    }

    public Mono<Feed> addFeed(Feed feed) {
        return repository.save(feed);
    }


    public Flux<Feed> getAllByTailing() {
        return this.repository.findWithTailableCursorBy().map(
            feed -> {
                log.info("Feed::" + feed);

                return feed;
            });
    }

}
