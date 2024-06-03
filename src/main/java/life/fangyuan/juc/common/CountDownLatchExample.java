package life.fangyuan.juc.common;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running");
                    // 模拟耗时操作
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 完成任务，计数器减一
                    latch.countDown();
                }
            }).start();
        }

        latch.await();  // 主线程等待其他线程完成任务
        System.out.println("All threads have finished.");
    }

}