package com.home.pojo;

import com.weatherpojo.WeatherEntity;
import lombok.Data;

@Data
public class Sprinkler {
    private Double temperature;
    private Double precipitation;
    private String weatherStatus;
    private String timeStamp;
    private String lastRun;
    private WeatherEntity weather;
}
