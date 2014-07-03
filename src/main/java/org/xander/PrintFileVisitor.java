package org.xander;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFileVisitor implements FileVisitor<Path> {
    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get("/home/xander/Downloads"), new PrintFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    int level;
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        withIndent(dir, level);
        level++;
        return FileVisitResult.CONTINUE;
    }

    private void withIndent(Path dir, int level) {
        System.out.println(dir.getFileName());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        withIndent(file, level);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        level--;
        return FileVisitResult.CONTINUE;
    }
}
