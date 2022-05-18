package com.home.controls;

import com.amazonaws.services.iot.client.AWSIotException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Gpiocontrols {
    void control() throws JsonProcessingException, AWSIotException;
    void runSprinkler() throws JsonProcessingException, AWSIotException;
}
