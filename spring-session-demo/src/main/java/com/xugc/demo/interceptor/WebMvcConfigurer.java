package com.xugc.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthInterceptpr authInterceptpr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptpr)
                .addPathPatterns("/test/sayHello");

        super.addInterceptors(registry);
    }
}
