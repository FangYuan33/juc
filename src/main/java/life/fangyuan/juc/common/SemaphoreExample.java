package life.fangyuan.juc.common;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> printer.print("Document " + Thread.currentThread().getName())).start();
        }
    }

    static class Printer {

        // 定义最大3个许可，即同时只能有3个线程访问
        private final Semaphore semaphore = new Semaphore(3);

        public void print(String document) {
            try {
                // 获取许可
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is printing " + document);
                Thread.sleep(2000); // 模拟打印过程
                System.out.println(Thread.currentThread().getName() + " has finished printing " + document);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放许可
                semaphore.release();
            }
        }
    }

}
