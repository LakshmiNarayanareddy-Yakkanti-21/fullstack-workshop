package io_concurrency.messaging;

import java.util.concurrent.*;

public class MessageQueue {

    private final BlockingQueue<Message> queue =
            new LinkedBlockingQueue<>();

    public void publish(Message m) throws InterruptedException {
        queue.put(m);
    }

    public Message consume() throws InterruptedException {
        return queue.take();
    }
}
