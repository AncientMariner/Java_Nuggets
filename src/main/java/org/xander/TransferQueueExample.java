package org.xander;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueExample implements Runnable {
    TransferQueue<String> queue;

    public TransferQueueExample(TransferQueue<String> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        TransferQueue<String> stringTransferQueue = new LinkedTransferQueue<>();
        try {
            stringTransferQueue.put("Await receipt");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TransferQueueExample transferQueue = new TransferQueueExample(stringTransferQueue);
        transferQueue.run();
    }

    @Override
    public void run() {
        while (true) {
            String message = produce();
            try {
                if (message.contains("Await receipt")) {
                    System.out.println("transfer done");
                    queue.transfer(message); // blocks if there is no matching take() pending
                } else {
                    System.out.println("put done");
                    queue.put(message); // returns immediately if the queue is not full
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String produce() {
        return "Await receipt";
    }
}