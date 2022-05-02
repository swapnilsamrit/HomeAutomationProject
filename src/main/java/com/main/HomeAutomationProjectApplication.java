package com.main;

import com.amazonaws.services.iot.client.AWSIotException;
import com.home.cloud.BootStrapService;
import com.home.cloud.aws.SprinklerMqttService;
import com.home.controls.Gpiocontrols;
import com.home.controls.SprinklerControls;
import com.home.mqtt.MqttClientServiceImpl;
import com.home.mqtt.MqttService;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.net.ssl.HostnameVerifier;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class HomeAutomationProjectApplication {
    @Autowired
    MqttClientServiceImpl service;

    static Logger logger = Logger.getLogger(HomeAutomationProjectApplication.class);
    public static void main(String[] args)  {
        logger.info("---Hello World!-HomeAutomationProjectApplication----");
        ConfigurableApplicationContext context = SpringApplication.run(HomeAutomationProjectApplication.class, args);

        BootStrapService bootStrapService=context.getBean(BootStrapService.class);
        bootStrapService.initSystem();

      //  Gpiocontrols gpiocontrols=  context.getBean(Gpiocontrols.class);
        //gpiocontrols.control();
        //MqttService mqttService=context.getBean(MqttService.class);
        //mqttService.mqttConnection();
       /* SprinklerMqttService mqttService=context.getBean(SprinklerMqttService.class);
        mqttService.connection();
        mqttService.connect();
        mqttService.subscribe("device");
        mqttService.subscribe("device/mayuri");
       // mqttService.subscribe("/device/swapnil");
        mqttService.publish("device","Code hello");*/

    }
}
