package com.xugc.demo.queue;

import java.util.Queue;

/**
 * Created by xuguocheng on 2017/7/3.
 */
public class SimpleQueueProducer<T> implements QueueProducer {

    private Queue queue;

    public SimpleQueueProducer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public boolean produce(Object msg) {
        boolean result = queue.offer(msg);
        return result;
    }
}
