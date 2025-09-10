package org;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class cbzSorter {
    // Utils


    /**
     * ToDo: unzip, rename, zip , move original to old, Reformat Errors
     *
     */
    public static void sorter() {
        Path destination = Path.of(manageProperties.prop.getProperty("destination"));
        try (var paths = Files.list(Path.of(manageProperties.prop.getProperty("source")))) {
            ArrayList<Path> pathsList = paths.collect(Collectors.toCollection(ArrayList::new));
            //paths.toList();
            for (Path cbzPath : pathsList) {
                //  Files.copy(cbzPath, destination.resolve(cbzPath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }


    /**
     * ToDo: Delete
     */
    public static void test() {
        System.out.println("Test");
    }
}
