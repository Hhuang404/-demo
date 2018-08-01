package com.hh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping(value = "getname")
    @ResponseBody
    public String getName(){
        return userService.getName();
    }

}
