package io_concurrency.messaging;

import java.util.concurrent.Executors;

public class MessagingTest {

    public static void main(String[] args) throws Exception {

        MessageQueue queue = new MessageQueue();

        try (var executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 1000; i++) {
                executor.submit(new MessageConsumer(queue));
            }

            new MessageProducer(queue).produce(10_000);
        }
    }
}
