package com.ygl.dao;

import com.ygl.entity.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> showAllDep();
    void addDep(Department department);
    void updateDep(Department department);
    Department selectOnebyId(Integer id);

}
