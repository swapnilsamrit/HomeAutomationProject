package com.main;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;
import com.common.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.cloud.aws.SprinklerTopic;
import com.home.cloud.aws.SampleUtil;
import com.home.pojo.Sprinkler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.*;

@Component
public class TestingClass {
    @Autowired
    ObjectMapper objectMapper=new ObjectMapper();

    public void sprinklerScheduler() {
        boolean flag = true;
        String lastTimeStamp = null;
        while (true) {
            if (getHour() >= 18 && getHour() <= 23) {
                //run once in 2 hour till 1 pm
                if (getMinute() == 21 && getHour() > 18 && flag == true) {
                    lastTimeStamp = new Date().toString();
                    //controlSprinkler();
                    System.out.println("condition matched");
                    flag = false;
                    break;
                } else {
                    System.out.println("run once in 1 hour last ran at " + getMinute());
                    flag = true;
                }
            } else {
                System.out.println("Current time is greater than the 6 PM of less than 9 AM, last run at " + lastTimeStamp);
            }
        }
    }

    private int getMinute() {
        return LocalTime.now().getMinute();
    }

    private int getHour() {
        return LocalTime.now().getHour();
    }

    private void AwsMqtt() throws AWSIotException, JsonProcessingException {
        String clientEndpoint = "a2nj8eajtz4tdu-ats.iot.us-east-1.amazonaws.com";//"<prefix>-ats.iot.<region>.amazonaws.com";
        String clientId = "awsClient_sprinkler";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
        String certificateFile = "src/main/resources/aws/074e5f19d9c41bb640c9e87fdeef3da037cd10171af08f0812bfb1918da58331-certificate.pem.crt";                       // X.509 based certificate file
        String privateKeyFile = "src/main/resources/aws/074e5f19d9c41bb640c9e87fdeef3da037cd10171af08f0812bfb1918da58331-private.pem.key";                        // PKCS#1 or PKCS#8 PEM encoded private key file

// SampleUtil.java and its dependency PrivateKeyReader.java can be copied from the sample source code.
// Alternatively, you could load key store directly from a file - see the example included in this README.
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore, pair.keyPassword);

// optional parameters can be set before connect()
        client.connect();
        client.publish(Constants.PUBLISH_DEVICE, objectMapper.writeValueAsString(new Sprinkler()));
        //client.subscribe(new AWSIotTopic("sub"));
        System.out.println("Published "+client.getConnectionStatus());
        String topicName = "devicetopic";
        AWSIotQos qos = AWSIotQos.QOS0;

        SprinklerTopic topic = new SprinklerTopic(topicName);
        client.subscribe(topic);
    }

    public static void main(String[] args) throws AWSIotException, JsonProcessingException {
        System.out.println(new Date().toString());
       // new TestingClass().AwsMqtt();
        System.out.printf("Mod " + (10 % 2));

        new TestingClass().cron();
      /*  ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{'name' : 'mkyong'}";
        System.out.printf(""+mapper.writeValueAsString(new Sprinkler()));*/
        // System.out.printf("ff "+LocalTime.now().getHour()%1);

        // new TestingClass().sprinklerScheduler();
        //System.out.println(LocalTime.now().getMinute());



       /* while (true){
            if (LocalTime.now().getMinute()%2==1){
                System.out.println("if: "+LocalTime.now().getMinute()%2);
            }else{
                System.out.println("else: "+LocalTime.now().getMinute()%2);
            }
        }*/
    }

    private void test() {
        ArrayList<String> strings = new ArrayList<>();
        // strings.add("s");
        strings.add("m");
        strings.add("g");
        strings.add("s");
        strings.add("s_s___s");
        strings.add("DSERT_ARCHIVED_ENV_WEBLOGIC_1032___DAVID_TEST_4_0_ADMIN_JDBC_DAVID_TEST_JDBC_1335548101715_david_test_levels_LEVELS_ALPS");
        strings.add("DSERT_ARCHIVED_ENV_WEBLOGIC_1032___DAVID_TEST_4_0_ADMIN_JDBC_DAVID_TEST_JDBC_1335548101715_david_test_levels_LEVELS_ALPS");
        System.out.println(strings.contains("s"));
        ArrayList check = strings;
        for (String s :
                strings) {
            if (strings.contains("s")) {
                // System.out.println("avaible " + s);
            }
        }

        // System.out.println("ce "+"s_s".equals("s_s"));
        Set<String> tSet = new HashSet<>();
        for (String i :
                strings) {
            if (!tSet.add(i)) {
                // throw new RuntimeException();
                System.out.println(" Duplicate " + i);
            }
        }
        //System.out.println(" Duplicate ppppp"+tSet);

    }

    @Scheduled(cron = "0 05 * * * ?")
   // @Scheduled(fixedRate = 1000)
    public void cron(){
        System.out.println("cron "+ Calendar.getInstance().getTime());
    }
}
