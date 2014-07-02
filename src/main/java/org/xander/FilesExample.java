package org.xander;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        try {
            Files.createDirectories(Paths.get("/home/xander/test"));
            Path file = Paths.get("/home/xander/test/test.txt");

            // no need to check prior to deletion
            Files.deleteIfExists(file);

            Files.createFile(file);
            Files.delete(file); // will fall if file does not exist

            Files.createFile(file);
            Path target = Paths.get("/home/xander/test/test.txt");

            //old school copy
            //Files.copy(file, target);

            // no exception although target already exists
            Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);

            //moving a file is easy (in jdk1.6 copy+delete or use renameTo)
          //  Files.move(target, file, StandardCopyOption.ATOMIC_MOVE);

            //read-write with one line
            Files.write(file, Arrays.asList("Foo", "Bar"), Charset.defaultCharset());

            List<String> lines = Files.readAllLines(file, Charset.defaultCharset());
            System.out.println(lines);

            //it has absolutely verified that file does not exist
            System.out.println(Files.notExists(file, LinkOption.NOFOLLOW_LINKS));
            //is not the same. True - exists, false - does not exist or its existence cannot be determined
            System.out.println(Files.exists(file, LinkOption.NOFOLLOW_LINKS));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
