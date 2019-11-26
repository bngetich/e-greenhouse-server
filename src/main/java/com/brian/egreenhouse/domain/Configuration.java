package com.brian.egreenhouse.domain;

import lombok.Data;

@Data
public class Configuration {

    final private String name;

    final private int maxTemperature;

    final private int minTemperature;

    final private int minHumidity;

    final private int maxHumidity;

    final private int minSoilMoisture;

    final private int maxSoilMoisture;

    public Configuration(String name, int maxTemperature, int minTemperature, int minHumidity, int maxHumidity, int minSoilMoisture, int maxSoilMoisture) {
        this.name = name;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
        this.minSoilMoisture = minSoilMoisture;
        this.maxSoilMoisture = maxSoilMoisture;
    }
}
