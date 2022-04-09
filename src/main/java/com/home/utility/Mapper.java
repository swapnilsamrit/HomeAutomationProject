package com.home.utility;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    private Map<String, Pin> raspiPinMap = new HashMap<String, Pin>();

    private void setMap() {
        raspiPinMap.put(Constant.SPRINKLER_GPIO, RaspiPin.GPIO_17);
    }

    public void getMapped(String s) {
    }
}
