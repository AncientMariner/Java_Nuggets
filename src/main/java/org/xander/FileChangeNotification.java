package org.xander;

import java.io.IOException;
import java.nio.file.*;

public class FileChangeNotification {
    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("/home/xander/test/");
            //registration for file/directory
            //registration is done on the object being watched. In this case the Path class
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);


            // poll for changes in a loop
            while (true) {
                // blocking. Unblocks as soon as stuff is created in the Directory
                WatchKey key = watchService.take();

                //iterate and process the events, they can be identified by their kind:
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path path = (Path) event.context();
                        System.out.println("additional info" + path.getFileSystem());
                        System.out.println("new entry " + path);
                    }
                }

                // must reset key in order to signal the watcher to keep monitoring the directory
                key.reset();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
