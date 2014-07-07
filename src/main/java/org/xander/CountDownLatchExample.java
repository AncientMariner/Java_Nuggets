package org.xander;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatchExample countDownLatch = new CountDownLatchExample();
        countDownLatch.initiateLatch();
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
