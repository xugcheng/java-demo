package com.xugc.demo.spring4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xuguocheng on 2017/7/20.
 */
@Component
public class MessagePrinter {

    final private MessageService messageService;

    @Autowired
    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(this.messageService.getMessage());
    }
}
