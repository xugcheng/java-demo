package com.xugc.demo.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by xuguocheng on 2017/7/4.
 */
public class Test {

    public static void main(String[] agrs) {

        Queue<String> queue = new ArrayBlockingQueue<>(10240);
        QueueManager queueManager = new QueueManager(queue);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            queueManager.addConsumer(new QueueConsumerListener() {
                @Override
                public void call(Object msg) {
                    System.out.println(index + "消费消息:" + msg);
                }
            });
        }
        queueManager.startConsumer();

        for (int i = 0; i < 100000; i++) {
            queueManager.getProducer().produce("msg" + i);
        }

    }
}
