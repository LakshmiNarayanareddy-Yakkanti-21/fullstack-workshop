package io_concurrency.messaging;

public class MessageProducer {

    private final MessageQueue queue;

    public MessageProducer(MessageQueue queue) {
        this.queue = queue;
    }

    public void produce(int count) throws InterruptedException {
        for (int i = 1; i <= count; i++) {
            queue.publish(new Message(i,"Msg",1));
        }
        System.out.println("Produced " + count + " messages");
    }
}
