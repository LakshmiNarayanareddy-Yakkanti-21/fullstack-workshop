package io_concurrency.messaging;

public record Message(int id, String content, int priority) {}
