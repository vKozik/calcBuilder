package ua.in.vkozik.calcbuilder.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HouseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HouseServiceApplication.class, args);
    }
}

