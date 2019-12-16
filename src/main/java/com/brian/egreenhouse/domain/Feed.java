package com.brian.egreenhouse.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Feed {

    @Id
    private String id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime created_at;

    private int field1;

    private int field2;

    private int field3;

}
