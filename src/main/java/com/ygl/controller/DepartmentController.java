package com.ygl.controller;

import com.ygl.entity.Department;
import com.ygl.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/showAllDep")
    public String showAllDep(HttpServletRequest request){
        List<Department> list = departmentService.showAllDep();
        request.setAttribute("list",list);
        return "departments";
    }

    @RequestMapping("addDep")
    public String addDep(Department department){
        departmentService.addDep(department);
        return "redirect:/dep/showAllDep";
    }

    @RequestMapping("selectOneById")
    public String selectOneById(Integer id,HttpServletRequest request){
        Department department = departmentService.selectOnebyId(id);
        request.setAttribute("department",department);
        return "updateDepartment";
    }
    @RequestMapping("updateDep")
    public String updateDep(Department department){
        departmentService.updateDep(department);
        return "redirect:/dep/showAllDep";
    }


}
