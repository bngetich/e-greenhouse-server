package com.brian.egreenhouse.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
public class Channel {

    @Id
    private int id;

    private String name;

    private GeoJsonPoint location;

    private String field1;

    private String field2;

    private String field3;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created_at;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updated_at;

    private Configuration configuration;


}
