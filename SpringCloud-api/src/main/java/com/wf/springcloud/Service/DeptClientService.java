package com.wf.springcloud.Service;

import com.wf.springcloud.bean.Dept;
import com.wf.springcloud.serviceImpl.DeptClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Component
//需要提供负载均衡的微服务名称
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory= DeptClientServiceImpl.class)
public interface DeptClientService {

    @GetMapping("/dept/query/{id}")
    Dept queryDept(@PathVariable("id") Long id);

    @GetMapping("/dept/getAll")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

}
