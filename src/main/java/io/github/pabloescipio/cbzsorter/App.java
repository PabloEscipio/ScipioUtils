package io.github.pabloescipio.cbzsorter;

import io.github.pabloescipio.cbzsorter.tui.TUIMenu;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ManageProperties.configLoad();

        TUIMenu menu = new TUIMenu("Menu", List.of("CBZ Sorter", "Config", "Test"));

        try {
            int choice = -1;
            while (choice != 0) {
                choice = menu.prompt();

                switch (choice) {
                    case 0 -> System.out.println("Exiting...");
                    case 1 -> CbzSorter.sorter();
                    case 2 -> editConfig();
                    case 3 -> CbzSorter.test();
                }
            }
        } catch (IOException ie) {
            System.err.printf("Error: %s\n", ie.getMessage());
        }
    }

    /**
     * Ask the user to input 2 paths and then edit the "config.properties" to store the information.
     *
     */
    public static void editConfig() throws IOException {
        // TODO: loop asking user confirmation, Reformat Errors
        // Try-with-resources with the scanner (prevents resource leaks)
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Source path:");
            ManageProperties.prop.setProperty("source", sc.nextLine());
            System.out.println("Destination path:");
            ManageProperties.prop.setProperty("destination", sc.nextLine());
            System.out.println("Old path:");
            ManageProperties.prop.setProperty("old", sc.nextLine());
            ManageProperties.prop.store(System.out, null);
            ManageProperties.prop.store(Files.newOutputStream(ManageProperties.config), null);
        }
    }
}
