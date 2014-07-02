package org.xander;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    static Path path = Paths.get("/home/xander", "Documents", "Java");

    public static void main(String[] args) {
        for (Path part : path) {
            System.out.println(part);
        }

        Path parentPath = path.getParent();
        System.out.println(parentPath);

        if (parentPath.compareTo(path) < 0) {
            Path anotherPath = Paths.get("/home/xander");
            System.out.println(anotherPath);

            Path relativePath = anotherPath.relativize(path); // Documents/Java
            System.out.println(relativePath);

            Path joinBackTogether = anotherPath.resolve(relativePath);
            System.out.println(joinBackTogether);
        }
    }
}
