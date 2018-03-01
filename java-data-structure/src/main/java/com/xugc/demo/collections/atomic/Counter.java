package com.xugc.demo.collections.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger ai = new AtomicInteger(0);

    private int i;

    public void safeCount() {

        for (; ; ) {
            int val = ai.get();
            boolean suc = ai.compareAndSet(val, ++val);
            if (suc) {
                break;
            }
        }
    }

    public void count() {
        i++;
    }

    public static void main(String[] args) {

        final Counter counter = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int k = 0; k < 100; k++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        counter.safeCount();
                        counter.count();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.ai.get());
        System.out.println(counter.i);
        System.out.println(System.currentTimeMillis() - start);
    }
}
