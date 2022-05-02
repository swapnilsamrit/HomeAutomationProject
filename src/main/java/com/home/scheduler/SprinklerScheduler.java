package com.home.scheduler;

import com.common.ConfigProperties;
import com.home.sprinkler.SprinklerImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.TimerTask;

/**
 * This class will run the scheduler at configured time interval
 */
@Component
public class SprinklerScheduler extends TimerTask {
    Logger logger = Logger.getLogger(SprinklerScheduler.class);
    SprinklerImpl sprinkler = new SprinklerImpl();

    @Autowired
    ConfigProperties config;
    boolean flag = false;

    @Override
    public void run() {
        // System.out.println("Turn On SPRINKLER: " + LocalTime.now());
        //run till evening 6pm
        if (LocalTime.now().getHour() >= 9 && LocalTime.now().getHour() <= 17) {//
            if (!flag && LocalTime.now().getHour() <= 14) {
                ///run sprinkler only once in 2 hour
                flag = true;
                logger.info("Setting flag to true and not running the sprinkler ");
            } else {
                //run sprinkler in every 60 min
                controlSprinkler();
                flag = false;
            }
        } else {
            logger.info("Sprinkler Time Exceeds, Current time is " + LocalTime.now());
        }
    }

    private void controlSprinkler() {
        try {
            logger.info("Turn On SPRINKLER: " + LocalTime.now());
            sprinkler.turnOn17sh();
            logger.info("Sleeping for sec " + config.getSleepTime());
            Thread.sleep(config.getSleepTime());
            sprinkler.turnOff17sh();
            logger.info("Turn Off SPRINKLER " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * using below logic in while loop is in case pi restart/power outage issue, so that it will not miss the timing unlike
     * timertask scheduler
     */
    public void sprinklerScheduler() {
        boolean flag = true;
        String lastTimeStamp = null;
        while (true) {
            if (getHour() >= config.getMorningTime() && getHour() <= config.getEveningTime()) {
                //run once in 2 hour till 1 pm
                if (getMinute() == config.getMinutes() && getHour() <= config.getHourlyTime() && flag == true) {
                    logger.info("last ran at " + lastTimeStamp);
                    lastTimeStamp = new Date().toString();
                  //  controlSprinkler();
                    flag = false;
                } else {
                    flag = true;
                }
            } else {
                logger.info("Now time is : "+new Date()+"  Current time is greater than the 6 PM or less than 9 AM hence not running it, last run at " + lastTimeStamp);
            }
        }
    }

    private int getMinute() {
        return LocalTime.now().getMinute();
    }

    private int getHour() {
        return LocalTime.now().getHour();
    }
}
