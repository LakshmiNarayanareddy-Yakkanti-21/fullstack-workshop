package io_concurrency.logs;

import java.nio.file.Path;
import java.util.List;

public class LogAnalyzerTest {

    public static void main(String[] args) throws Exception {

        LogAnalyzer analyzer = new LogAnalyzer();

        List<LogEntry> logs =
                analyzer.readLogs(Path.of("io_concurrency/logs/app.log"));

        System.out.println(analyzer.countByLevel(logs));

        analyzer.writeSummary(
                Path.of("io_concurrency/logs/summary.txt"),
                logs
        );
    }
}
