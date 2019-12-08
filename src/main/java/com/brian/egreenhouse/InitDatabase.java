package com.brian.egreenhouse;

import com.brian.egreenhouse.web.rest.client.ThinkSpeakJsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InitDatabase {

    private static final Logger log = LoggerFactory.getLogger(InitDatabase.class);

    @Bean
    CommandLineRunner init(MongoOperations operations,
                           WebClient client){
        return args -> {
            ThinkSpeakJsonResponse response = client.get()
                    .uri("/channels/554640/feeds.json")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(ThinkSpeakJsonResponse.class)
                    .log("init")
                    .block();

            response.channel.setFeeds(response.feeds);
            operations.save(response.channel);
        };
    }
}