package com.xugc.demo.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xuguocheng on 2017/7/3.
 */
public class QueueManager {

    private Queue queue;

    private QueueProducer producer;

    private List<QueueConsumer> consumers;

    public QueueManager(Queue queue) {
        this.queue = queue;
        this.producer = new SimpleQueueProducer(queue);
        this.consumers = new ArrayList<>();
    }

    public QueueProducer getProducer() {
        return producer;
    }

    public void addConsumer(QueueConsumer consumer) {
        this.consumers.add(consumer);
    }

    public void addConsumer(QueueConsumerListener listener) {
        this.consumers.add(new SimpleQueueConsumer(this.queue, listener));
    }

    public void startConsumer() {
        for (QueueConsumer consumer : consumers) {
            new Thread(consumer).start();
        }
    }
}
