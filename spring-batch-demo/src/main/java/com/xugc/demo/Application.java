package com.xugc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by xuguocheng on 2017/9/6.
 */
@SpringBootApplication
@MapperScan(value = "com.xugc.demo.dao")
public class Application {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
