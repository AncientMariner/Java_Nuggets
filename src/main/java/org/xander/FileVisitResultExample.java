package org.xander;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitResultExample {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("/home/xander/"), new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path p, BasicFileAttributes attributes) {
                if (p.getFileName().toString().equals("a.out")) {
                    System.out.println(p);
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
