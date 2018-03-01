package com.xugc.demo.collections.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 当我们不想生产者过度生产消息时,TransferQueue非常有用,可避免OutOfMemory错误.
 * 在这样的设计中,消费者的消费能力将决定生产者生产消息的速度.
 *
 * doc : https://segmentfault.com/a/1190000011266361
 */
public class LinkedTransferQueueDemo {

    static LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<>();

    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(2);
        LinkedTransferQueueDemo demo = new LinkedTransferQueueDemo();
        Producer producer = demo.new Producer();
        Consumer consumer = demo.new Consumer();
        exec.execute(producer);
        exec.execute(consumer);
        exec.shutdown();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Producer is waiting for transfer ...");
                    lnkTransQueue.transfer("A" + i);
                    System.out.println("producer transfered element : A" + i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {

                try {
                    System.out.println("Consumer is waiting to take element...");
                    String s = lnkTransQueue.take();
                    System.out.println("Consumer received Element: " + s);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
