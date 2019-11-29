package com.ygl.service;

import com.ygl.aspect.Log;
import com.ygl.dao.DepartmentDao;
import com.ygl.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Department> showAllDep() {
        return departmentDao.showAllDep();
    }

    @Log(message = "添加了一个部门")
    @Override
    public void addDep(Department department) {
        departmentDao.addDep(department);
    }

    @Log(message = "修改了一个部门")
    @Override
    public void updateDep(Department department) {
        departmentDao.updateDep(department);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Department selectOnebyId(Integer id) {
        return departmentDao.selectOnebyId(id);
    }

}
