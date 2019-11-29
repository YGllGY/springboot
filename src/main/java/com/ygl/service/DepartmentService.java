package com.ygl.service;

import com.ygl.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> showAllDep();
    void addDep(Department department);
    void updateDep(Department department);
    Department selectOnebyId(Integer id);
}
