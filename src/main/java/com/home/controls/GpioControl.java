package com.home.controls;


import com.home.scheduler.SprinklerScheduler;

import java.util.Timer;

public class GpioControl {
    Timer t = new Timer();
    SprinklerScheduler s = new SprinklerScheduler();

    public void startSprinkler() {
        t.schedule(s, 2000, 360*100*100);
    }
}
