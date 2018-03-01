package com.xugc.demo.collections.lock;

/**
 * park和wait的区别。wait让线程阻塞前，必须通过synchronized获取同步锁
 */
public class WaitTest1 {

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        synchronized (ta) {
            try {
                System.out.println(Thread.currentThread().getName() + " start ta");
                ta.start();

                System.out.println(Thread.currentThread().getName() + " block");
                ta.wait();

                System.out.println(Thread.currentThread().getName() + " continue ");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                this.notify();
            }
        }
    }
}
