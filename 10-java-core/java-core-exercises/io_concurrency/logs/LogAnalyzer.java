package io_concurrency.logs;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LogAnalyzer {


    public List<LogEntry> readLogs(Path file) throws IOException {
        List<LogEntry> logs = new ArrayList<>();

        for (String line : Files.readAllLines(file)) {
            String[] parts = line.split(" ", 4);
            logs.add(new LogEntry(
                    parts[0] + " " + parts[1],
                    parts[2],
                    parts[3]
            ));
        }
        return logs;
    }

  
    public Map<String, Long> countByLevel(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::level,
                        Collectors.counting()
                ));
    }

   
    public List<LogEntry> getErrors(List<LogEntry> logs) {
        return logs.stream()
                .filter(l -> l.level().equals("ERROR"))
                .toList();
    }

   
    public void writeSummary(Path output, List<LogEntry> logs) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("Total logs: " + logs.size());
        countByLevel(logs).forEach(
                (k,v) -> lines.add(k + " = " + v)
        );
        Files.write(output, lines);
    }
}
