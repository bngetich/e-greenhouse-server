package com.brian.egreenhouse.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Feed {
    @Indexed(direction = IndexDirection.ASCENDING)
    private int entryId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    private int temperature;

    private int humidity;

    private int soilMoisture;

    public Feed(LocalDateTime createdAt, int temperature, int humidity, int soilMoisture) {
        this.createdAt = createdAt;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
    }
}
