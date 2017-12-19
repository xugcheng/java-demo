package com.xugc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5 * 60 * 60)
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
