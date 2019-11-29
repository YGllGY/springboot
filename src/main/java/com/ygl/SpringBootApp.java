package com.ygl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ygl.dao")
@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class,args);
    }
}

//打war包
//public class SpringBootApp extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootApp.class,args);
//    }
//
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(SpringBootApp.class);
//    }
//
//}
