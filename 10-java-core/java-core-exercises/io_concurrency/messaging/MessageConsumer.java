package io_concurrency.messaging;

public class MessageConsumer implements Runnable {

    private final MessageQueue queue;

    public MessageConsumer(MessageQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                queue.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
