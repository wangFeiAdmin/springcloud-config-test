package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka 服务，表示当前可以接受别人注册进来
public class EurekaServer_8085 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_8085.class,args);
    }
}
