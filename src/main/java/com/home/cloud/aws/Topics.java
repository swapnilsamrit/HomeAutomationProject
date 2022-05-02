package com.home.cloud.aws;

import com.amazonaws.services.iot.client.AWSIotTopic;

public interface Topics {


    void onMessageArrival(String payload);

    void setSubTopic(String awsIotTopic);
}
