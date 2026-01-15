package io_concurrency.config;

import java.io.*;
import java.nio.file.Path;

public class ConfigManager {

    public static void saveConfig(AppConfig config, Path file)
            throws IOException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(file.toFile()))) {
            out.writeObject(config);
        }
    }

    public static AppConfig loadConfig(Path file)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(file.toFile()))) {
            return (AppConfig) in.readObject();
        }
    }
}
