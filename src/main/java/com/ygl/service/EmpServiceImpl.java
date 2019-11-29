package com.ygl.service;

import com.ygl.aspect.Log;
import com.ygl.dao.EmpDao;
import com.ygl.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> selectAllEmp(String id) {
        return empDao.selectAllEmp(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp selectOnebyId(Integer id) {
        return empDao.selectOnebyId(id);
    }

    @Override
    @Log(message = "添加了一个员工")
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }

    @Override
    @Log(message = "修改了一个员工")
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    @Log(message = "删除了一个员工")
    public void deleteEmpById(Integer id) {
        empDao.deleteEmpById(id);
    }

}
