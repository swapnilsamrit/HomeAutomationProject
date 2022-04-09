package com.home.scheduler;

import com.home.gpio.GpioUtility;

import java.util.Date;
import java.util.TimerTask;

public class DripperScheduler extends TimerTask {
    GpioUtility gpioUtility = new GpioUtility();

    @Override
    public void run() {
        System.out.println("Turn On Dripper: " + new Date().getSeconds());
        try {
            gpioUtility.on();
            System.out.println("Sleeping for 5 sec");
            Thread.sleep(5000);
            gpioUtility.off();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Turn Off Dripper" + new Date().getSeconds());
    }

}
