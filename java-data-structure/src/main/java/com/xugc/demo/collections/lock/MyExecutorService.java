package com.xugc.demo.collections.lock;

import java.util.concurrent.*;

public class MyExecutorService extends ThreadPoolExecutor {


    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("beforeExecute:" + t + "," + r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("afterExecute:" + t + "," + r);
    }

    @Override
    protected void terminated() {
        super.terminated();
        System.out.println("this.isTerminated()=" + this.isTerminated());
    }

    public static void main(String[] args) {

        MyExecutorService exec = new MyExecutorService(4, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        exec.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行");
            }
        });
        exec.shutdown();
    }
}
