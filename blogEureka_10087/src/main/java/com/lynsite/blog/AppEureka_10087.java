package com.lynsite.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka_10087 {
    public static void main( String[] args )
    {
        SpringApplication.run(AppEureka_10087.class, args);
    }
}
