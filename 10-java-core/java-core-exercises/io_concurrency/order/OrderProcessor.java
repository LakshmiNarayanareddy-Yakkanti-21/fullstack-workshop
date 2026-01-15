package io_concurrency.order;

import java.util.concurrent.*;

public class OrderProcessor {

    public CompletableFuture<String> processOrder() {

        CompletableFuture<String> user =
                CompletableFuture.supplyAsync(() -> {
                    sleep(500);
                    return "User";
                });

        CompletableFuture<String> product =
                CompletableFuture.supplyAsync(() -> {
                    sleep(300);
                    return "Product";
                });

        return user.thenCombine(product, (u,p) -> u + " ordered " + p)
                .thenApply(order -> {
                    sleep(1000);
                    return "Order completed";
                })
                .exceptionally(ex -> "Order failed");
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) {}
    }
}
