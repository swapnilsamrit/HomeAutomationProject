package com.home.cloud;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.common.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.cloud.aws.SampleUtil;
import com.home.cloud.aws.SprinklerMqttService;
import com.home.cloud.aws.SprinklerTopic;
import com.home.controls.Gpiocontrols;
import com.home.pojo.Sprinkler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootStrapImpl implements BootStrapService {
    Logger logger = Logger.getLogger(BootStrapImpl.class);
    @Autowired
    SprinklerMqttService mqttService;

    @Autowired
    Gpiocontrols gpiocontrols;

    @Override
    public boolean initNetworks() {
        //TODO initialize all the networks here
        return true;
    }

    @Override
    public boolean initMqtt() {
        mqttService.connection();
        try {
            mqttService.connect();
            logger.info("AWS MQTT connection is ready!");
            return true;
        } catch (AWSIotException e) {
            logger.error("e " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initSystem() {
        logger.info("Create MQTT connection");
         initMqtt();
        // gpiocontrols.control();
        gpiocontrols.runSprinkler();
    }


}
