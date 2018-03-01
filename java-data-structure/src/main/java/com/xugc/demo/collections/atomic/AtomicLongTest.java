package com.xugc.demo.collections.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

    /**
     * 保证原子性
     */
    public AtomicLong al = new AtomicLong(0);

    /**
     * volatile 保证可见性,但不能保证原子性
     */
    public volatile long l = 0;

    public void safeCount() {
        al.incrementAndGet();
    }

    public void count() {
        l++;
    }

    public static void main(String[] args) {

        AtomicLongTest test = new AtomicLongTest();

        Thread[] ts = new Thread[100];
        for (int i = 0; i < ts.length; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        test.count();
                        test.safeCount();
                    }
                }
            });
            ts[i] = t;
        }

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(test.al);
        System.out.println(test.l);
    }
}
