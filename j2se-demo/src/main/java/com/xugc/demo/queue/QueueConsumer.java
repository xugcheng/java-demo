package com.xugc.demo.queue;

/**
 * 消息队列消费者接口
 * Created by xuguocheng on 2017/7/3.
 */
public interface QueueConsumer<T> extends Runnable {

    /**
     * 消息出队列
     *
     * @return
     */
    public T consume();

    /**
     * 消息出队列,并回调.
     *
     * @param callback
     */
    public void consume(QueueConsumerListener callback);
}
