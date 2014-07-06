package org.xander;

import java.io.IOException;
import java.nio.file.*;

public class ZipExample {
    public static void main(String[] args) {
        Path zipFile = Paths.get("/home/xander/test/zippy.zip");
        Path jarFile = Paths.get("/home/xander/test/zippy.jar");

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, null)) {
            Files.deleteIfExists(Paths.get("/home/xander/test/passageExtracted.txt"));
            Files.copy(zipFileSys.getPath("passage.txt"), Paths.get("/home/xander/test/passageExtracted.txt"));

            Path plainFile = Paths.get("/home/xander/test/passageToZip.txt");

            Files.deleteIfExists(zipFileSys.getPath("newFile.txt"));
            Files.copy(plainFile, zipFileSys.getPath("newFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
