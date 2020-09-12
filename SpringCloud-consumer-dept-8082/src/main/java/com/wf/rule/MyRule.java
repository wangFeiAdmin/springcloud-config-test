package com.wf.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MyRule {
    @Bean
    public IRule getIRule(){
        return  new MyRandomRule();
    }

}
