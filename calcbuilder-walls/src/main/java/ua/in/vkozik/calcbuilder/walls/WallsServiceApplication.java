package ua.in.vkozik.calcbuilder.walls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WallsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WallsServiceApplication.class, args);
    }
}
