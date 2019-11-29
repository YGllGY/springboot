package com.ygl.controller;


import com.ygl.entity.Department;
import com.ygl.entity.Emp;
import com.ygl.service.DepartmentService;
import com.ygl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/showEmpByDepId")
    public String showEmpByDepId(String depnumber, HttpServletRequest request){
        List<Emp> list = empService.selectAllEmp(depnumber);
        request.setAttribute("list",list);
        return "emplist";
    }
    @RequestMapping("/showAllDep")
    public String showAllDep(HttpServletRequest request){
        List<Department> departments = departmentService.showAllDep();
        request.setAttribute("departments",departments);
        return "addEmp";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Emp emp, HttpServletRequest request, HttpSession session){
        emp.setImage((String) session.getAttribute("image"));
        empService.addEmp(emp);
        request.setAttribute("depnumber",emp.getDepnumber());
        session.removeAttribute("image");
        return "forward:/emp/showEmpByDepId";
    }
    @RequestMapping("/deleteEmp")
    public String deleteEmp(Emp emp,HttpServletRequest request){
        empService.deleteEmpById(emp.getId());
        request.setAttribute("depnumber",emp.getDepnumber());
        return "forward:/emp/showEmpByDepId";
    }
    @RequestMapping("/updateEmp")
    public String updateEmp(Emp emp,HttpSession session,HttpServletRequest request){
        if(session.getAttribute("image")!=null){
            emp.setImage((String) session.getAttribute("image"));
        }
        empService.updateEmp(emp);
        request.setAttribute("depnumber",emp.getDepnumber());
        session.removeAttribute("image");
        return "forward:/emp/showEmpByDepId";
    }

    @RequestMapping("selectOnebyId")
    public String selectOnebyId(Integer id,HttpServletRequest request){
        Emp emp = empService.selectOnebyId(id);
        List<Department> departments = departmentService.showAllDep();
        request.setAttribute("departments",departments);
        request.setAttribute("emp",emp);
        return "updateEmp";
    }

}
