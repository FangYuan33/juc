package life.fangyuan.juc.WorkerThread;

public class Main {
    public static void main(String[] args) {
        // 线程池线程的个数
        Channel channel = new Channel(5);
        channel.startWorkers();

        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
