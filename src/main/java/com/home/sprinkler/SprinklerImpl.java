package com.home.sprinkler;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class SprinklerImpl implements SprinklerService {

    public void turnOn17sh() {
        System.out.println("run turnOn17sh");
        ProcessBuilder processBuilder = new ProcessBuilder("/home/pi/Desktop/SwitchON17.sh");
        try {

            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
                // System.exit(0);
            } else {
                //abnormal...
            }
            //TODO send notification to cloud
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void turnOff17sh() {
        System.out.println("run turnOff17sh");
        ProcessBuilder processBuilder = new ProcessBuilder("/home/pi/Desktop/SwitchOFF17.sh");
        try {

            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
                // System.exit(0);
            } else {
                //abnormal...
            }
            //TODO send notification to cloud
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

