package life.fangyuan.juc.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                example.before();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                example.after();
            }
        });
        t2.start();
    }

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void before() {
        try {
            lock.lock();
            System.out.println("before");
            condition.signalAll();
            condition.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        try {
            lock.lock();
            System.out.println("after");
            condition.signalAll();
            condition.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
