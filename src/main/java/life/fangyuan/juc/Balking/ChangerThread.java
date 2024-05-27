package life.fangyuan.juc.Balking;

import java.io.IOException;
import java.util.Random;

/**
 * 用户线程
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                // 修改数据
                data.change("No." + i);
                // 执行其他操作
                Thread.sleep(random.nextInt(1000));
                // 显式地保存
                data.save();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
