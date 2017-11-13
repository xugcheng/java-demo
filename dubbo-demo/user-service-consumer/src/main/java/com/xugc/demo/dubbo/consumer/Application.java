package com.xugc.demo.dubbo.consumer;

import com.xugc.demo.dubbo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by xuguocheng on 2017/4/22.
 */
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("dubbo-consumer 启动.");

        UserService userService = ctx.getBean("userService", UserService.class);

        String msg = userService.sayHello("dubbo");

        System.out.println("sayHello:" + msg);

        System.in.read();
    }
}
