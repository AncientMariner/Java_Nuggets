package org.xander;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDirectoryContentsExample {
    public static void main(String[] args) {
        File file = new File("/home/xander/test");
        String[] names = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        for (String name : names) {
            System.out.println(name);
        }

        iterateOverADirectoryWithoutPreloadingItsContentIntoMemory();
    }

    public static void iterateOverADirectoryWithoutPreloadingItsContentIntoMemory() {
        // ConcurrentModificationException is not thrown
        // we should not rely on the behaviour when one or more files are created during the execution
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get("/home/xander/test"))) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
