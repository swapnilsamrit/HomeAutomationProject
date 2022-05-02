package com.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:configs.properties")
public class ConfigProperties {
    @Value("${config.cityName}")
    private String cityName;
    @Value("${config.apiKey}")
    private String apiKey;
    @Value("${config.url_current}")
    private String url_current;

    @Value("${config.url_forcast}")
    private String url_forecast;

    @Value("${config.sleep}")
    private int sleepTime;
    @Value("${config.morningtime}")
    private int morningTime;
    @Value("${config.eveningtime}")
    private int eveningTime;
    @Value("${config.minute}")
    private int minutes;

    @Value("${config.hourlytime}")
    private int hourlyTime;

    @Value("${config.temp}")
    public Double temp;

    @Value("${config.preci}")
    public Double preci;

    @Value("${config.clientEndpoint}")
    public String clientEndpoint;

    @Value("${config.clientId}")
    public String clientId;

    @Value("${config.certificateFile}")
    public String certificateFile;

    @Value("${config.privateKeyFile}")
    public String privateKeyFile;


}
