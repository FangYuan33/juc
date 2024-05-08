package life.fangyuan.juc.common;

public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 has finished running");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is running");
            try {
                // Here we call join() on thread1, so thread2 will wait until thread1 has finished.
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 has finished running");
        });

        thread1.start();
        thread2.start();
    }
}
