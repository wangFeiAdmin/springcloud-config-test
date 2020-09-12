package com.wf.springcloud.serviceImpl;

import com.wf.springcloud.Service.DeptClientService;
import com.wf.springcloud.bean.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceImpl implements FallbackFactory {


    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService(){

            @Override
            public Dept queryDept(Long id) {
                Dept p=new Dept();
                p.setDeptname("当前为降级操作，降级操作中的熔断");
                return p;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
