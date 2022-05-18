package test;

import com.main.TestingClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.InetAddress;
import java.util.Calendar;
//@SpringBootApplication
//@EnableScheduling
public class TestBootClass {
   // @Scheduled(initialDelay = 1000, fixedRate = 10000)
    //@Scheduled(cron = "0 * * * * *")
    public void run() {
        System.out.println("-Current time is :: " + Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
       // ConfigurableApplicationContext context = SpringApplication.run(TestBootClass.class, args);
        System.out.println("Hello boot");
        //context.getBean(TestBootClass.class).run();
        new TestBootClass().checkPing();
    }
    private void checkPing() {
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
            boolean reachable = address.isReachable(10000);

            System.out.println("Is host reachable? " + reachable);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
