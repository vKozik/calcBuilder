package ua.in.vkozik.calcbuilder.roof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RoofServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoofServiceApplication.class, args);
    }
}
