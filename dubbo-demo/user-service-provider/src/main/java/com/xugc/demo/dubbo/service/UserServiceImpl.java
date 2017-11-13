package com.xugc.demo.dubbo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuguocheng on 2017/4/22.
 */
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String sayHello(String name) {

        System.out.println("sayHello:" + name);

        return "Hello " + name;
    }

}
