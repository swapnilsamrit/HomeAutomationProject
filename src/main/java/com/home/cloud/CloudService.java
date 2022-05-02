package com.home.cloud;

import com.weatherpojo.WeatherEntity;

public interface CloudService {
    WeatherEntity getCurrentWeatherData();
    WeatherEntity getForecastData();
}
