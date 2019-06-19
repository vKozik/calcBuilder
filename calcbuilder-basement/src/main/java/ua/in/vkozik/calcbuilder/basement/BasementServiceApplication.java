package ua.in.vkozik.calcbuilder.basement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BasementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasementServiceApplication.class, args);
    }
}
