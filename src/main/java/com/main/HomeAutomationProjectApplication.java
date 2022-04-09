package com.main;

import com.home.controls.GpioControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeAutomationProjectApplication {

	public static void main(String[] args) {
		System.out.printf("Hello World!!!");
		SpringApplication.run(HomeAutomationProjectApplication.class, args);
		System.out.println("Hello World!");
		GpioControl gpioControl = new GpioControl();
		//sprinkler.runSprinkler();
		gpioControl.startSprinkler();
	}

}
