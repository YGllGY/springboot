package com.ygl.service;

import com.ygl.entity.Log;

import java.util.List;

public interface LogService {

    void addLog(Log log);
    List<Log> showAllLog();
}
