package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;


@SpringBootApplication
@EnableZuulProxy //开启zuul
public class DeptZuul_9091{
    public static void main(String[] args) {
        SpringApplication.run(DeptZuul_9091.class,args);
    }
}
