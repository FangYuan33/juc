package life.fangyuan.juc.common;

public class Synchronized {

    public synchronized void test1() throws InterruptedException {
        System.out.println("test1");
        Thread.sleep(2000);
    }

    public synchronized void test2() throws InterruptedException {
        System.out.println("test2");
        Thread.sleep(2000);
    }
}
