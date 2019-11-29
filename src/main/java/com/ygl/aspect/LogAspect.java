package com.ygl.aspect;


import com.ygl.service.LogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private LogServiceImpl logService;

    @Around("pt()")
    public Object emsAround(ProceedingJoinPoint proceedingJoinPoint){

        HttpSession session = request.getSession();
        Object user = session.getAttribute("username");
        String username= user.toString();

        Date date = new Date();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String methodName = annotation.message();

        boolean flag = false;
        Object proceed =null;
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        com.ygl.entity.Log log = new com.ygl.entity.Log();
        log.setName(username).setMethodmessage(methodName).setQuantum(date).setResult(flag+"");
        logService.addLog(log);
        LogAspect.log.info("when:{}--->  who:{}--->what:{}--->result:{}",new SimpleDateFormat("yyyy年MM月dd日: hh-mm-ss").format(date),username,methodName,flag);

        return proceed;
    }



    @Pointcut("@annotation(com.ygl.aspect.Log)")
    public void pt(){

    }

}
