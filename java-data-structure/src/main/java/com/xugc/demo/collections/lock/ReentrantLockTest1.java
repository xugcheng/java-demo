package com.xugc.demo.collections.lock;

/**
 * 可重入锁
 */
public class ReentrantLockTest1 implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {

        ReentrantLockTest1 task = new ReentrantLockTest1();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
