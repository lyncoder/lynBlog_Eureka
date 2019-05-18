package com.lynsite.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/29 21:10
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.lynsite.blog"})
@ComponentScan("com.lynsite.blog")  //客户端，扫描并注册为bean
public class BlogConsumer_8002 {
    public static void main(String[] args) {
        SpringApplication.run(BlogConsumer_8002.class, args);
    }
}
