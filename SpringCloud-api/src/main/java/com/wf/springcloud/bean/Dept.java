package com.wf.springcloud.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Dept implements Serializable {
    private  Long deptno;
    private String deptname;
    private String  dataName;

    public Dept (String deptname){
        this.deptname=deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", dataName='" + dataName + '\'' +
                '}';
    }
}
