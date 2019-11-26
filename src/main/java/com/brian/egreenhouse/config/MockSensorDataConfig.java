package com.brian.egreenhouse.config;

import com.brian.egreenhouse.web.rest.client.SensorDataWebClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackageClasses = SensorDataWebClient.class)
public class MockSensorDataConfig {
}
