package com.brian.egreenhouse.web.rest.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class SensorDataWebClientTest {

    private static final Logger log = LoggerFactory.getLogger(SensorDataWebClient.class);

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void updateSensorDataWithMockValuesShouldWork() {
        //given
        int temperature = 26;
        int humidity = 58;
        int soilMoisture = 72;

        //when
        webTestClient.post()
                .uri("https://api.thingspeak.com" +
                        "/update.json?api_key=JFF2RCZQBULIFXRX" +
                        "&field1=" + temperature +
                        "&field2=" + humidity +
                        "&field3=" + soilMoisture)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .exchange();

        //then
        FluxExchangeResult<ThinkSpeakJsonResponse> exchangeResult = webTestClient
                .get()
                .uri("https://api.thingspeak.com/channels/554640/feeds.json?results=1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .returnResult(ThinkSpeakJsonResponse.class);

        StepVerifier.create(
                exchangeResult.getResponseBody()
                .flatMap(response -> Flux.fromIterable(response.feeds))
                .next())
                .expectNextMatches(feed ->{
                    assertThat(feed.getTemperature()).isEqualTo(temperature);
                    assertThat(feed.getHumidity()).isEqualTo(humidity);
                    assertThat(feed.getSoilMoisture()).isEqualTo(soilMoisture);
                    return true;
                });
    }
}