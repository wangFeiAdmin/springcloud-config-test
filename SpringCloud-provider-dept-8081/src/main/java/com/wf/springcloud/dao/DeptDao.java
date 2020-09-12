package com.wf.springcloud.dao;

import com.wf.springcloud.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
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
