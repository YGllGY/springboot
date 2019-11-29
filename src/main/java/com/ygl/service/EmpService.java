package com.ygl.service;

import com.ygl.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAllEmp(String id);

    Emp selectOnebyId(Integer id);

    void addEmp(Emp emp);

    void updateEmp(Emp emp);

    void deleteEmpById(Integer id);
}
