package com.hh.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
*author huangh
*date 2018/7/25 16:45
*description springBoot入口，启动器
*/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    //执行run启动springBoot服务
        SpringApplication.run(Application.class,args);
    }

}

