package com.ygl.test;

import com.ygl.SpringBootApp;
import com.ygl.entity.Admin;
import com.ygl.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringBootApp.class)
@RunWith(SpringRunner.class)
public class AdminTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void test1(){
        List<Admin> list = adminService.selectAllAdmin();
        for (Admin admin : list) {
            System.out.println(admin);
        }

    }
}
