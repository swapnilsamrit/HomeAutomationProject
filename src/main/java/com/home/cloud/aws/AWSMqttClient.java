package com.home.cloud.aws;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.common.ConfigProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AWSMqttClient implements SprinklerMqttService {
    Logger logger = Logger.getLogger(AWSMqttClient.class);
    @Autowired
    ConfigProperties config;

    AWSIotMqttClient client;


    @Override
    public void publish(String topic, String payload) throws AWSIotException {
        client.publish(topic, payload);
    }

    @Override
    public void connection() {
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(config.certificateFile, config.privateKeyFile);
        client = new AWSIotMqttClient(config.clientEndpoint, config.clientId, pair.keyStore, pair.keyPassword);
        //connectionI();
    }

    @Override
    public void connect() throws AWSIotException {
        client.connect();
    }

    @Override
    public void disconnect() throws AWSIotException {
        client.disconnect();

    }

    @Override
    public void subscribe(String topic) throws AWSIotException {
        client.subscribe(new SprinklerTopic(topic));
        logger.info("Subscribed to Topic: "+topic);
    }

    @Override
    public String getConnectionStatus() {
        return client.getConnectionStatus().toString();
    }

   // @Override
    public void connectionI() {
        String clientEndpoint = "a2nj8eajtz4tdu-ats.iot.us-east-1.amazonaws.com";//"<prefix>-ats.iot.<region>.amazonaws.com";
        String clientId = "awsClient_sprinklerm";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
        String certificateFile = "src/main/resources/aws/074e5f19d9c41bb640c9e87fdeef3da037cd10171af08f0812bfb1918da58331-certificate.pem.crt";                       // X.509 based certificate file
        String privateKeyFile = "src/main/resources/aws/074e5f19d9c41bb640c9e87fdeef3da037cd10171af08f0812bfb1918da58331-private.pem.key";                        // PKCS#1 or PKCS#8 PEM encoded private key file

// SampleUtil.java and its dependency PrivateKeyReader.java can be copied from the sample source code.
// Alternatively, you could load key store directly from a file - see the example included in this README.
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        client = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore, pair.keyPassword);

// optional parameters can be set before connect()

    }
}
