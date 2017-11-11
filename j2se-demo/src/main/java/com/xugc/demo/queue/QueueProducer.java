package com.xugc.demo.queue;

/**
 * 消息队列-生产者接口.
 * Created by xuguocheng on 2017/7/3.
 */
public interface QueueProducer<T> {

    /**
     * 消息进队列
     *
     * @param msg
     * @return
     */
    public boolean produce(T msg);
}
