package org.xander;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class SymbolicLinksExample {
    public static void main(String[] args) {
//        walkOldStyle(new File("/home/xander"));
        aNewWalk();
    }

    public static void walkOldStyle(File file) {
        System.out.println(file.getPath());
        if (file.isFile()) {
            return; // leaf element
        }

        File[] subs = file.listFiles();  // directory
        if (subs == null) {
            return;
        }

        for (File subDir : subs) {  // go deeper
            walkOldStyle(subDir.getAbsoluteFile());
        }
    }

    public static void aNewWalk() {
        try {
            String firstDirectoryName = "/home/xander/test/test1";
            String secondDirectoryName = "/home/xander/test/test1/test2";
            String fileOne = "/home/xander/test/test1/firstFile.txt";
            String nameOfTheLinkToFileOne = "/home/xander/test/test1/test2/linkToFirst.txt";

            Files.createDirectory(Paths.get(firstDirectoryName));
            Files.createDirectory(Paths.get(secondDirectoryName));
            Files.createFile(Paths.get(fileOne));
            Path linkToFile = Files.createSymbolicLink(Paths.get(nameOfTheLinkToFileOne), Paths.get(fileOne));

            Files.createSymbolicLink(Paths.get("/home/xander/test/test1/test2/linkToDirectory"),
                                     Paths.get(firstDirectoryName)); // circular link

            if (Files.isSameFile(Paths.get(fileOne), linkToFile)) {
                Files.write(Paths.get(fileOne), Arrays.asList("Hello"), Charset.defaultCharset());

                List<String> lines = Files.readAllLines(linkToFile, Charset.defaultCharset());

                assert lines.get(0).equals("Hello");
            }

            Files.walkFileTree(Paths.get(firstDirectoryName), EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                    Integer.MAX_VALUE,
                    new SimpleFileVisitor<Path>(){
                public FileVisitResult visitFileFailed(Path path, IOException e) {
                    System.out.println((FileSystemLoopException) e);
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
