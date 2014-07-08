package org.xander;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatchExample countDownLatch = new CountDownLatchExample();
//        countDownLatch.initiateLatch();
        countDownLatch.phaser();
    }

    private void phaser() {
        int count = 4;

        final Phaser phaser = new Phaser();
        phaser.register();

        for (int i = 0; i < count; i++) {
            phaser.register();
            final int localCount = i;

            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(localCount * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(localCount);
                    phaser.arrive();
                }
            }).start();
        }
    }

    private void initiateLatch() {
        int count = 4;
        final CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            final int localCount = i;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(localCount * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(localCount);
                    latch.countDown();

                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
