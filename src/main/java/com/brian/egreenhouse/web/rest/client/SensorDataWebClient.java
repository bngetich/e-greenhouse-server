package com.brian.egreenhouse.web.rest.client;

import com.brian.egreenhouse.domain.Feed;
import com.brian.egreenhouse.service.ChannelService;
import com.brian.egreenhouse.web.rest.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class SensorDataWebClient {

    @Autowired
    private WebClient client;

    @Autowired
    ChannelService service;

    private static final Logger log = LoggerFactory.getLogger(SensorDataWebClient.class);

    @Scheduled(cron = "*/60 * * * * *")
    public void updateSensorDataWithMockValues() {
        int temperature = RandomUtil.getRandomInteger(25, 31);
        int humidity = RandomUtil.getRandomInteger(55, 61);
        int soilMoisture = RandomUtil.getRandomInteger(70, 76);

        client.post()
                .uri("/update.json?api_key=JFF2RCZQBULIFXRX" +
                     "&field1=" + temperature +
                     "&field2=" + humidity +
                     "&field3=" + soilMoisture)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve()
                .bodyToMono(Feed.class)
                .flatMap(feed -> service.addFeed(feed))
                .subscribe();
    }



}
