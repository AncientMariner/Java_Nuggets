package org.xander;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilteringTheDirectory {
    public static void main(String[] args) {
//        try (DirectoryStream<Path> ds = Files.newDirectoryStream(
//                Paths.get("/home/xander/test"), "*.{txt,jsp,xml}")) {
//            for (Path file : ds) {
//                System.out.println(file.getFileName());
//                Files.deleteIfExists(file);
//                Files.createFile(file.getParent().resolve(file.getFileName()));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        filterFiles();
    }

    public static void filterFiles() {
        try {
            DirectoryStream<Path> largerThanFourBytes = Files.newDirectoryStream(
                    Paths.get("/home/xander/test"), new DirectoryStream.Filter<Path>(){
                        @Override
                        public boolean accept(Path entry) throws IOException {
                            return Files.size(entry) > 4;
                        }
            });
            for (Path file : largerThanFourBytes) {
                System.out.println(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
