package com.ygl.service;

import com.ygl.dao.LogDao;
import com.ygl.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private  LogDao logDao;

    @Override
    public void addLog(Log log) {
        logDao.addLog(log);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Log> showAllLog() {
        List<Log> list = logDao.showAllLog();
        return list;
    }
}
