package io.github.pabloescipio.cbzsorter;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;


public class TUICbzSorter {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Load Properties
        ManageProperties.configLoad();
        //Variables
        byte index = 0;

        // Program
        do {
            try {
                // UMenu
                index = Byte.parseByte(UIndex());
                // Menu
                switch (index) {
                    case 0 -> System.out.println("Closing...");
                    case 1 -> CbzSorter.sorter();
                    case 2 -> editConfig();
                    case 3 -> CbzSorter.test();
                    default -> System.out.println("Index doesn't exist");
                }
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        } while (index != 0);
        sc.close();
    }

    /**
     * Show the user a menu with options to chose
     * ToDo: Reformat
     */
    public static String UIndex() {
        System.out.println(
                """
                        -----MENU-----
                        1. CBZ Sorter
                        2. Config
                        3. Test
                        0. Exit Program
                        """
        );
        return sc.nextLine();
    }

    /**
     * Ask the user to input 2 paths and then edit the "config.properties" to store the information.
     * ToDO: loop asking user confirmation, Reformat Errors
     */
    public static void editConfig() throws IOException {
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
