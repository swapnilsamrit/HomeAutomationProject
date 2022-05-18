package com.home.controls;

import com.amazonaws.services.iot.client.AWSIotException;
import com.common.ConfigProperties;
import com.common.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.cloud.CloudService;
import com.home.cloud.aws.SprinklerMqttService;
import com.home.pojo.Sprinkler;
import com.home.sprinkler.SprinklerService;
import com.weatherpojo.WeatherEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Component
@EnableScheduling
public class SprinklerControls implements Gpiocontrols {
    Logger logger = Logger.getLogger(SprinklerControls.class);
    private WeatherEntity weather;

    @Autowired
    ConfigProperties config;

    @Autowired
    CloudService cloudService;

    @Autowired
    SprinklerService sprinklerService;

    @Autowired
    SprinklerMqttService mqttService;

    Sprinkler sprinkler;

    @Autowired
    ObjectMapper objectMapper;

    String lastTimeStamp = null;

    @Override
    public void control() throws JsonProcessingException, AWSIotException {

       /* while (true) {
            if (getHour() >= config.getMorningTime() && getHour() <= config.getEveningTime()) {
                // System.out.println("TIME------");
                //run once in 2 hour till 1 pm
                if (getMinute() == config.getMinutes()) {
                    //TODO check mod of hours, if 0 then process further till 13.00 hours IST
                    if (getHour() < config.getHourlyTime() && getHour() % 2 == 0) {
                        logger.info("publish to cloud at " + LocalTime.now());
                        this.sprinkler = new Sprinkler();

                        if (checkWeatherStatus()) {
                            logger.info(" Before 1 PM " + LocalTime.now());
                            startSprinkler();
                            logger.info(Constants.PUBLISH_DEVICE + " Before 1PM, Data publish to cloud at " + objectMapper.writeValueAsString(getPayload(lastTimeStamp)));
                            lastTimeStamp = LocalTime.now().toString();
                            sleepUtil(55000);
                        }
                    }

                    if (getHour() >= config.getHourlyTime()) {
                        if (checkWeatherStatus()) {
                            logger.info("After 1 PM " + LocalTime.now());
                            startSprinkler();
                            logger.info(Constants.PUBLISH_DEVICE + " After 1 PM Data publish to cloud at " + objectMapper.writeValueAsString(getPayload(lastTimeStamp)));
                            lastTimeStamp = LocalTime.now().toString();
                            sleepUtil(55000);
                        }
                    }
                }
            }
        }*/
    }

    private void startSprinkler() {
        controlSprinkler();

    }

    private Sprinkler getPayload(String lastTimeStamp) {
        sprinkler.setWeatherStatus(weather.getCurrent().getCondition().getText());
        sprinkler.setPrecipitation(weather.getCurrent().getPrecipMm());
        sprinkler.setLastRun(lastTimeStamp);
        sprinkler.setTimeStamp(new Date().toString());
        sprinkler.setTemperature(weather.getCurrent().getTempC());
        sprinkler.setWeather(weather);
        return sprinkler;
    }

    private void sleepUtil(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            logger.info("e " + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will check the current weather condition and allow sprinkler to run
     *
     * @return true or false
     */
    private boolean checkWeatherStatus() {
        weather = cloudService.getCurrentWeatherData();
        if (weather.getCurrent().getTempC() < config.getTemp() && weather.getCurrent().getPrecipMm() > config.getPreci()) {
            logger.info("May be it's raining raining outside, not running sprinkler");
            return false;
        } else {
            logger.info("Weather is ! " + weather.getCurrent().getCondition().getText());
            return true;
        }
    }

    private int getMinute() {
        return LocalTime.now().getMinute();
    }

    private int getHour() {
        return LocalTime.now().getHour();
    }

    private void controlSprinkler() {
        try {
            logger.info("Turn On SPRINKLER: " + LocalTime.now());
            sprinklerService.turnOn17sh();
            logger.info("Sleeping for sec " + config.getSleepTime());
            Thread.sleep(config.getSleepTime());
            sprinklerService.turnOff17sh();
            logger.info("Turn Off SPRINKLER " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("e " + e);
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void runSprinkler() throws JsonProcessingException, AWSIotException {
        if (getHour() >= config.getMorningTime() && getHour() <= config.getEveningTime()) {
            // checkPing();
            //run once in 2 hr
            //check time in minute
            if (getHour() < config.getHourlyTime() && getHour() % 2 == 0) {
                if (getMinute() == config.getMinutes()) {
                    mqttService.publish(Constants.PUBLISH_DEVICE.trim().toString(), "Before Welcome at " + Calendar.getInstance().getTime());
                    logger.info("Ready publish to cloud at!!! " + LocalTime.now());
                    this.sprinkler = new Sprinkler();
                    if (checkWeatherStatus()) {
                        logger.info("Before 1 PM, Current time " + Calendar.getInstance().getTime());
                        logger.info("is Mqtt connection status " + mqttService.getConnectionStatus());
                        mqttService.publish(Constants.PUBLISH_DEVICE, objectMapper.writeValueAsString(getPayload(this.lastTimeStamp)));
                        startSprinkler();
                        logger.info(" Before 1PM, Data publish to cloud at " + Constants.PUBLISH_DEVICE);
                        lastTimeStamp = LocalTime.now().toString();
                    }
                }
            }
        }
        if (getHour() >= config.getHourlyTime() && getHour() <= config.getEveningTime()) {
            //run every hour
            if (getMinute() == config.getMinutes()) {
                this.sprinkler = new Sprinkler();
                mqttService.publish(Constants.PUBLISH_DEVICE.trim().toString(), "After Welcome at " + Calendar.getInstance().getTime());
                if (checkWeatherStatus()) {
                    logger.info("After 1 PM,Current Time " + Calendar.getInstance().getTime());
                    logger.info("is Mqtt connection status " + mqttService.getConnectionStatus());
                    mqttService.publish(Constants.PUBLISH_DEVICE, objectMapper.writeValueAsString(getPayload(this.lastTimeStamp)));
                    startSprinkler();
                    logger.info(" After 1 PM Data publish to cloud at " + Constants.PUBLISH_DEVICE);
                    lastTimeStamp = LocalTime.now().toString();
                }
            }
        }
    }

    private void checkPing() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            boolean reachable = address.isReachable(10000);

            System.out.println("Is host reachable? " + reachable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}