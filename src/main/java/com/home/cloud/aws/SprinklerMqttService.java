package com.home.cloud.aws;

import com.amazonaws.services.iot.client.AWSIotException;

public interface SprinklerMqttService {

    void publish(String topic, String payload) throws AWSIotException;

    void connection();

    void connect() throws AWSIotException;

    void disconnect() throws AWSIotException;

    void subscribe(String topic) throws AWSIotException;

    String getConnectionStatus();
}
