package com.ygl.dao;

import com.ygl.entity.Log;

import java.util.List;

public interface LogDao {

    void addLog(Log log);
    List<Log> showAllLog();
}
