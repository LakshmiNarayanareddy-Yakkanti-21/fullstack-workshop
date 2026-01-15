package io_concurrency.download;

import java.util.List;
import java.util.concurrent.*;

public class DownloadManager {

    private final ExecutorService executor;

    public DownloadManager(int threads) {
        executor = Executors.newFixedThreadPool(threads);
    }

    public void downloadAll(List<String> urls) {
        try {
            for (String url : urls) {
                executor.submit(new DownloadTask(url));
            }
        } finally {
            executor.shutdown();
        }
    }
}
