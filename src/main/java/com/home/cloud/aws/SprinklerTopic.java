package com.home.cloud.aws;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotTopic;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SprinklerTopic extends AWSIotTopic {
    Logger logger = Logger.getLogger(SprinklerTopic.class);
    public SprinklerTopic(@Value("${config.subTopic}") String topic) {
        super(topic);
    }


    @Override
    public void onMessage(AWSIotMessage message) {
        // called when a message is received
        //System.out.printf("Received msg:  " + message.getStringPayload());
        logger.info("Received msg:  " + message.getStringPayload());
    }
}


