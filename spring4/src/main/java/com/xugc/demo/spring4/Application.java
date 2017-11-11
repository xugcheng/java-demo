package com.xugc.demo.spring4;

import com.xugc.demo.spring4.service.MessagePrinter;
import com.xugc.demo.spring4.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by xuguocheng on 2017/7/20.
 */
@Configuration
@ComponentScan
@ImportResource(value = "classpath:applicationContext.xml")
public class Application {

    @Bean
    public MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
