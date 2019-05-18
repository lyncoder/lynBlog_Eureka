package com.lynsite.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *      面向接口中 FeignClientService 所在的包，Feign的负载均衡中集成了Ribbon，
 *      面向接口，则使用熔断器 Hystrix 是，可以依照FeignClientService封装改接口中方法
 *      对应的所有回滚函数，也需要通过此注解方式引入
 */
@SpringBootApplication
public class BlogWebApp {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebApp.class, args);
    }

}
