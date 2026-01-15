package io_concurrency.order;

public class OrderTest {
    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        processor.processOrder()
                .thenAccept(System.out::println)
                .join();
    }
}
