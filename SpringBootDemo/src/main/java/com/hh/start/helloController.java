package com.hh.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @Autowired
    private Environment environment;

    @RequestMapping("/info")
    public String info(){
        return "hello springBoot,读取properties文件中的配置"+environment.getProperty("url")+
               "目前使用的端口号1"+environment.getProperty("server.port");
    }
    @RequestMapping("/info1")
    public String info2(){
        return "hello springBoot,读取properties文件中的配置"+environment.getProperty("url")+
               "目前使用的端口号"+environment.getProperty("server.port");
    }

}
