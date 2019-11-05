package com.brian.egreenhouse.web.rest;

import com.brian.egreenhouse.web.rest.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class MockSensorData {

    private WebClient client = WebClient.create("https://api.thingspeak.com");

    private static final Logger log = LoggerFactory.getLogger(MockSensorData.class);

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
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(String.class))
                .subscribe(log::info);
    }
}
