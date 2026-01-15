package io_concurrency.config;

import java.nio.file.Path;

public class ConfigTest {
    public static void main(String[] args) throws Exception {

        AppConfig config =
                new AppConfig("MyApp","1.0",100,30000);

        ConfigManager.saveConfig(
                config,
                Path.of("io_concurrency/config/app.ser")
        );

        AppConfig loaded =
                ConfigManager.loadConfig(
                        Path.of("io_concurrency/config/app.ser")
                );

        System.out.println("Loaded at: " + loaded.getLastLoaded());
    }
}
