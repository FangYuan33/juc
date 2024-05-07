package life.fangyuan.juc.GuardedSuspension;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RequestQueue requestQueue = new RequestQueue();
        ClientThread alice = new ClientThread(requestQueue, "Alice", 3141592L);
        alice.start();
        ServerThread bobby = new ServerThread(requestQueue, "Bobby", 6535897L);
        bobby.start();

        // 主线程终止两个线程，注意在 ClientThread 和 ServerThread 的实现中，它们都调用了 sleep() 方法，
        // 所以在终止时会抛出 InterruptedException，我们再将这个异常抛出即可完成线程任务的终止
        Thread.sleep(3000);
        System.out.println("Calling interrupt()...");
        alice.interrupt();
        bobby.interrupt();
        System.out.println("Finished");
    }
}
