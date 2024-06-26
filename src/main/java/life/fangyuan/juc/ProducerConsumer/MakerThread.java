package life.fangyuan.juc.ProducerConsumer;

import java.util.Random;

public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    // 蛋糕的流水号(所有糕点师共用)
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
