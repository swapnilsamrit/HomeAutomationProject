package com.home.mqtt;

import com.common.ConfigProperties;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttClientServiceImpl implements MqttService, MqttCallback {
    Logger logger = Logger.getLogger(MqttClientServiceImpl.class);

    @Autowired
    ConfigProperties config;

    // client, user and device details
    final String serverUrl = "tcp://mqtt.thingsboard.cloud:1883";//tcp://broker.hivemq.com:1883";     /* ssl://mqtt.cumulocity.com:8883 for a secure connection */
    final String clientId = "4350";
    final String device_name = "My Java MQTT device";
    final String tenant = "<<tenant_ID>>";
    final String username = "9deb7540-c567-11ec-9326-ad8278896f52";//"username";
    final String password = "password";
    MqttClient client;

    @Override
    public void mqttConnection(String url, String usernam, String password) throws MqttException {

    }

    @Override
    public void mqttConnection() throws MqttException {
        // MQTT connection options
        MqttConnectOptions options = new MqttConnectOptions();

        options.setUserName(username);
        options.setPassword(password.toCharArray());
        client = new MqttClient(serverUrl, clientId, null);
        connect();
    }

    @Override
    public void connect() throws MqttException {

        client.connect();
        client.setCallback(this);
        logger.info("Mqtt Connection success!");
    }

    @Override
    public void disconnect() throws MqttException {
        client.disconnect();
        logger.info("oops! Mqtt Disconnected!");
    }

    @Override
    public void retry() {

    }

    @Override
    public void publish(String topic, MqttMessage message) throws MqttException {
        client.publish(topic, message);
    }

    @Override
    public void subscribe(String topic) throws MqttException {
        client.subscribe(topic);
    }

    @Override
    public void connectionLost(Throwable throwable) {
        //TODO reconnect upon connection lost
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //TODO process incoming msg from here
        System.out.println("IIIIMessage Received:: " + s + " :: " + mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        //TODO get delivery msg here and process
    }
}
