package com.ygl.service;

import com.ygl.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> selectAllAdmin();
    void  addAdmin(Admin admin);
}
