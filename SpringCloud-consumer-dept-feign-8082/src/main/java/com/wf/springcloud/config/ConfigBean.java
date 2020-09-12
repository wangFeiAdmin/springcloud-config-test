package com.wf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //注册远程调用的模板
    @Bean
    @LoadBalanced //添加ribbo 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
