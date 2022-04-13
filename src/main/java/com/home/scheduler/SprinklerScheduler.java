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
    boolean flag = false;

    @Override
    public void run() {
        // System.out.println("Turn On SPRINKLER: " + LocalTime.now());
        //run till evening 6pm
        if (LocalTime.now().getHour() >= 9 && LocalTime.now().getHour() <= 17) {//
            if (!flag && LocalTime.now().getHour() <= 14) {
                ///run sprinkler only once in 1 hour
                flag = true;
                logger.info("Setting flag to true and not running the sprinkler");
            } else {
                //run sprinkler in every 30 min
                controlSprinkler();
                flag = false;
            }

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
            logger.info("Sleeping for sec " + 50000);
            Thread.sleep(50000);
            sprinkler.turnOff17sh();
            logger.info("Turn Off SPRINKLER " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Turn Off SPRINKLER " + LocalTime.now());
    }
}
