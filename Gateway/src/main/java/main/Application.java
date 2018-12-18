package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@EnableEurekaClient
@Configuration
@SpringBootApplication
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
