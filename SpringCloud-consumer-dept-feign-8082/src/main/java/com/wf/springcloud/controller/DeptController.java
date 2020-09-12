package com.wf.springcloud.controller;

import com.wf.springcloud.Service.DeptClientService;
import com.wf.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptClientService deptClientService=null;//此处没有实现类所以应该留空
    /**
     * 查询指定部门
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept  get(@PathVariable("id") Long id){
        return deptClientService.queryDept(id);
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */

    @RequestMapping("/consumer/dept/add")
    public  boolean  add(Dept dept){
        return deptClientService.addDept(dept);
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> selectAll(){
        return  deptClientService.queryAll();

    }
}
