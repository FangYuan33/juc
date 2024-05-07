package life.fangyuan.juc.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println(Thread.currentThread().getName() + ": wait() begins, queue = " + queue);
                wait();
                System.out.println(Thread.currentThread().getName() + ": wait() ends,   queue = " + queue);
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }

    // 交换 queue.offer(request) 和 notifyAll() 的位置，RequestQueue 还能不能安全的运行？
    // 是可以安全运行的，因为 getRequest() 方法和 putRequest() 获取的是同一个锁，所以即便是先唤醒线程也并不会立即释放锁，而是等到执行完 offer()
    // 方法后才会释放锁，其他被阻塞的线程获取到锁后继续判断执行，当然写成如下这种更容易理解
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println(Thread.currentThread().getName() + ": notifyAll() begins, queue = " + queue);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": notifyAll() ends, queue = " + queue);
    }

    // 也可以使用阻塞队列来实现
    private final LinkedBlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();

    public Request getRequestBlocking() throws InterruptedException {
        return blockingQueue.take();
    }

    public void putRequestBlocking(Request request) {
        blockingQueue.offer(request);
    }
}
