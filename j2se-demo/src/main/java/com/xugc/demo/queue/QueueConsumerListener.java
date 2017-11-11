package com.xugc.demo.queue;

/**
 * Created by xuguocheng on 2017/7/3.
 */
public interface QueueConsumerListener<T> {

    public void call(T msg);
}
