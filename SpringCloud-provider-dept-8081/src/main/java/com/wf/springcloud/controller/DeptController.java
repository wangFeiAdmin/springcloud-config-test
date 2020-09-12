package com.wf.springcloud.controller;


import com.wf.springcloud.bean.Dept;
import com.wf.springcloud.dao.DeptDao;
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

    //获取注册进来的微服务消息
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获得微服务清单，即所有注册的微服务
        List<String> services = client.getServices();
        System.out.println("信息："+services);
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                       instance.getHost()+"\t"+
                       instance.getInstanceId()+"\t"+
                       instance.getScheme()+"\t+"+
                       instance.getUri()
            );

        }
        return this.client;
    }



    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        System.out.println(dept);
        return deptService.addDept(dept);
    }

   @GetMapping("/dept/query/{id}")
    public Dept getDept(@PathVariable("id") Long deptno) {
       Dept dept = new Dept();
       dept.setDeptno(deptno);
       return deptService.queryDept(dept);
    }

   @GetMapping("/dept/getAll")
    public List<Dept> getAll() {
        return deptService.queryAll();
    }
}
