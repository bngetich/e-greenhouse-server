package com.brian.egreenhouse.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Configuration {

    private String name;

    private int maxTemperature;

    private int minTemperature;

    private int minHumidity;

    private int maxHumidity;

    private int minSoilMoisture;

    private int maxSoilMoisture;

}
