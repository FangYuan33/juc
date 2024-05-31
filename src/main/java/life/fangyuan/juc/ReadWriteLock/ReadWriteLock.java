package life.fangyuan.juc.ReadWriteLock;

public final class ReadWriteLock {
    // (A)…实际正在读取中的线程个数
    private int readingReaders = 0;
    // (B)…正在等待写入的线程个数
    private int waitingWriters = 0;
    // (C)…实际正在写入中的线程个数
    private int writingWriters = 0;
    // 若写入优先，则为true
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        // (A) 实际正在读取的线程个数加1
        readingReaders++;
    }

    public synchronized void readUnlock() {
        // (A) 实际正在读取的线程个数减1
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        // (B) 正在等待写入的线程个数加1
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            // (B) 正在等待写入的线程个数减1
            waitingWriters--;
        }
        // (C) 实际正在写入的线程个数加1
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        // (C) 实际正在写入的线程个数减1
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }
}
