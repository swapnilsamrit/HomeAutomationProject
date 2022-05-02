package com.home.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MqttService {


    void mqttConnection(String url, String usernam, String password) throws MqttException;

    void mqttConnection() throws MqttException;

    void connect() throws MqttException;

    void disconnect() throws MqttException;

    void retry();

    void publish(String topic, MqttMessage message) throws MqttException;

    void subscribe(String topic) throws MqttException;
}
