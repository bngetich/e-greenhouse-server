package com.brian.egreenhouse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackageClasses = com.brian.egreenhouse.web.rest.MockSensorData.class)
public class MockSensorDataConfig {
}
