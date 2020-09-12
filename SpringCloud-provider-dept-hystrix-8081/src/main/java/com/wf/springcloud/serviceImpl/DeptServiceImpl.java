package com.wf.springcloud.serviceImpl;

import com.wf.springcloud.bean.Dept;
import com.wf.springcloud.dao.DeptDao;
import com.wf.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;


    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDept(Dept dept) {
        return deptDao.queryDept(dept);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
