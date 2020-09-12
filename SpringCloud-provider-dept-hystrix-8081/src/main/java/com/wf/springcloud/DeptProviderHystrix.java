package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //服务启动后自动注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //开启服务熔断
public class DeptProviderHystrix {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix.class,args);
    }
}
