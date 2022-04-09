package com.home.gpio;

import com.pi4j.io.gpio.*;

public class GpioUtility {
    GpioController gpioController = null;
    GpioPinDigitalOutput pin;

    public GpioUtility() {
        this.gpioController = GpioFactory.getInstance();
        this.factory();
    }

    private void factory() {
        pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Sprinkler", PinState.LOW);
    }

    public void on() {
        //pin.setShutdownOptions(true, PinState.LOW);
        pin.high();
    }

    public void off() {
        //  pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Sprinkler", PinState.LOW);
        pin.low();
    }
}
