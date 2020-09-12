package com.wf.springcloud.controller;

import com.wf.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;
    // 模块 SpringCloud-provider-dept-8081的访问地址
   // private static final String REST_URL_PREFIX="http://localhost:8081";
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * 查询指定部门
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept  get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/query/"+id,Dept.class);
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */

    @RequestMapping("/consumer/dept/add")
    public  boolean  add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> selectAll(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/getAll",List.class);
    }
}
