package com.lynsite.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/30 10:31
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class BlogTurbine_App {
    public static void main(String[] args) {
        SpringApplication.run(BlogTurbine_App.class, args);
    }
}
