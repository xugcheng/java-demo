package com.xugc.demo.queue;

import java.util.Queue;

/**
 * Created by xuguocheng on 2017/7/3.
 */
public class SimpleQueueConsumer<T> implements QueueConsumer {

    private Queue<T> queue;

    private QueueConsumerListener<T> listener;

    public SimpleQueueConsumer(Queue<T> queue, QueueConsumerListener listener) {
        this.queue = queue;
        this.listener = listener;
    }

    @Override
    public T consume() {
        T msg = queue.poll();
        return msg;
    }

    @Override
    public void consume(QueueConsumerListener callback) {
        T msg = queue.poll();
        if (msg != null) {
            this.listener.call(msg);
        }
    }

    @Override
    public void run() {
        for (; ; ) {
            T msg = this.consume();
            if (msg != null) {
                this.listener.call(msg);
            }
        }
    }
}
