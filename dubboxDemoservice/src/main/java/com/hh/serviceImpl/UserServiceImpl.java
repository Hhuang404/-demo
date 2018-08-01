package com.hh.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hh.service.UserService;
@Service
public class UserServiceImpl  implements UserService {

    public String getName() {
        return "hello";
    }
}
