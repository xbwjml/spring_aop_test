package com.itheima.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("indexService")
public class IndexServiceImpl {

//    @Resource(name="userService")
//    private UserServiceImpl userService;

    public IndexServiceImpl(){
        System.out.println("Constructor of IndexServiceImpl");
    }

//    public void getService(){
//        System.out.println(userService);
//    }
}
