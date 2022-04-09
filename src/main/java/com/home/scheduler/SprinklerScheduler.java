package com.home.scheduler;

import com.home.sprinkler.SprinklerImpl;
import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.util.TimerTask;

/**
 * This class will run the scheduler at configured time interval
 */
public class SprinklerScheduler extends TimerTask {
    Logger logger = Logger.getLogger(SprinklerScheduler.class);
    SprinklerImpl sprinkler = new SprinklerImpl();

    @Override
    public void run() {
        // System.out.println("Turn On SPRINKLER: " + LocalTime.now());
        //run till evening 6pm
        if (LocalTime.now().getHour() >= 9 && LocalTime.now().getHour() <= 17) {//
            controlSprinkler();
        } else {
            //System.out.println("Sprinkler Time Exceeds, Current time is " + LocalTime.now());
            logger.info("Sprinkler Time Exceeds, Current time is " + LocalTime.now());
        }
    }

    private void controlSprinkler() {
        try {
            logger.info("Turn On SPRINKLER: " + LocalTime.now());
            sprinkler.turnOn17sh();
            //System.out.println("Sleeping for sec " + 5000);
            logger.info("Sleeping for sec " + 25000);
            Thread.sleep(25000);
            sprinkler.turnOff17sh();
            logger.info("Turn Off SPRINKLER " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Turn Off SPRINKLER " + LocalTime.now());
    }
}
