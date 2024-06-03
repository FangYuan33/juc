package life.fangyuan.juc.common;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int threadCount = 10;
        final CyclicBarrier barrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is ready");
                    // 等待其他线程准备就绪
                    barrier.await();
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}