package life.fangyuan.juc.WorkerThread;

import java.util.LinkedList;

public class Channel {
    // 最大请求数
    private static final int MAX_REQUEST = 100;

    private final LinkedList<Request> requestQueue;

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new LinkedList<>();

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (WorkerThread workerThread : threadPool) {
            workerThread.start();
        }
    }

    public synchronized void putRequest(Request request) {
        while (requestQueue.size() >= MAX_REQUEST) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestQueue.addLast(request);
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (requestQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Request request = requestQueue.removeFirst();
        notifyAll();
        return request;
    }
}
