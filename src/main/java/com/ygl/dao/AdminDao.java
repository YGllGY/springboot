package com.ygl.dao;

import com.ygl.entity.Admin;

import java.util.List;


public interface AdminDao {

    List<Admin> selectAllAdmin();
    void  addAdmin(Admin admin);
}
