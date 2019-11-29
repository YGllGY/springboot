package com.ygl.controller;


import com.ygl.entity.Admin;
import com.ygl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/selectAllAdmin")
    public String selectAllAdmin(Admin admin,HttpSession session){
        List<Admin> list = adminService.selectAllAdmin();
        for (Admin adm : list) {
            if(adm.getUsername().equals(admin.getUsername())&&adm.getPassword().equals(admin.getPassword())){
                session.setAttribute("username",adm.getUsername());
                return "redirect:/dep/showAllDep";
            }
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("addAdmin")
    public String addAdmin(Admin admin,HttpSession session){
        adminService.addAdmin(admin);
        session.setAttribute("username",admin.getUsername());
        return "redirect:/dep/showAllDep";
    }


    @RequestMapping(value = "verifyAdmin",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String verifyAdmin(String username,HttpServletResponse response) throws IOException {
        List<Admin> list = adminService.selectAllAdmin();
        String str="";
        for (Admin admin : list) {
            if(username.equals(admin.getUsername())){
                str="用户名已存在";
            }
        }
        return str;
    }
}
