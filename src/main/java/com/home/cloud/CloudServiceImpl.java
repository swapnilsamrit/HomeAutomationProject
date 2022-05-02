package com.home.cloud;


import com.common.ConfigProperties;
import com.weatherpojo.WeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CloudServiceImpl implements CloudService {
    @Autowired
    private ConfigProperties config;

    /**
     * this method will call to api of weatherapi portal and return the
     * all weather parameters of current date based on city provided
     * @return
     */
    @Override
    public WeatherEntity getCurrentWeatherData() {
        String url = config.getUrl_current()+config.getCityName();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", config.getApiKey());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<WeatherEntity> response = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherEntity.class);
        return response.getBody();
    }

    @Override
    public WeatherEntity getForecastData() {
        String url = config.getUrl_forecast()+config.getCityName();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", config.getApiKey());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<WeatherEntity> response = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherEntity.class);
        System.out.println("Response: " + response.getBody().getLocation().getName());
        System.out.println("Forecast: "+response.getBody().getForecast().getForecastday().get(0).getDay().getAvgtempC());
        /*ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(response.getBody().getForecast().getForecastday().get(0).getHour().get(15));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);*/
        return response.getBody();
    }
}
