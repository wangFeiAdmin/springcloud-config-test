package com.wf.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wf.springcloud.bean.Dept;
import com.wf.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    @Qualifier("deptServiceImpl")
    private DeptService deptService;

   @GetMapping("/dept/query/{id}")
   @HystrixCommand(fallbackMethod="hystrixGetDept") //当该方法发生异常，则会被熔断，
   // 调用注解中提供的 hystrixGetDept 方法
    public Dept getDept(@PathVariable("id") Long deptno) {
       Dept dept = new Dept();
       dept.setDeptno(deptno);
       Dept dept1 = deptService.queryDept(dept);

       if(dept1==null){
           throw new RuntimeException("当前这个id不存在，没有查询到用户");
       }
       return dept1;
    }


// 注： 熔断的方法需要参数列表和原方法保持一致
    public Dept hystrixGetDept(@PathVariable("id") Long deptno) {
        Dept dept = new Dept();
        dept.setDeptname("当前用户不存在，抛出虚拟用户");
        return dept;
    }
}
