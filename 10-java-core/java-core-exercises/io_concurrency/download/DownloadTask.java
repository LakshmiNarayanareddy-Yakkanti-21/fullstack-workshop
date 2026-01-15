package io_concurrency.download;

public class DownloadTask implements Runnable {

    private final String url;

    public DownloadTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            for (int p : new int[]{0,25,50,75,100}) {
                System.out.println(Thread.currentThread().getName()
                        + " Downloading " + url + " " + p + "%");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
