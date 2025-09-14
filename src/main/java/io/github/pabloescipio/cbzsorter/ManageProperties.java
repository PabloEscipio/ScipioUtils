package io.github.pabloescipio.cbzsorter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ManageProperties {

    public static Path config = Paths.get("config.properties");
    public static Properties prop = new Properties();

    /**
     * ToDo: Reformat Errors
     */
    public static void configLoad() {
        try {
            InputStream is = Files.newInputStream(config);
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Loading Error: " + e);
        }
    }

}
