package com.wf.springcloud.service;

import com.wf.springcloud.bean.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 添加部门
     * @param dept
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 查询指定部门
     * @param dept
     * @return
     */
    Dept queryDept(Dept dept);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> queryAll();
}
