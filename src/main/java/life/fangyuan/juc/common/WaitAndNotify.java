package life.fangyuan.juc.common;

public class WaitAndNotify {

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                waitAndNotify.a2();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                waitAndNotify.b2();
            }
        });
        t2.start();
    }

    private final Object lock = new Object();

    public void a2() {
        synchronized (lock) {
            try {
                System.out.println("a2");
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void b2() {
        synchronized (lock) {
            try {
                System.out.println("b2");
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void a() {
        try {
            System.out.println("a1");
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        try {
            System.out.println("b1");
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
