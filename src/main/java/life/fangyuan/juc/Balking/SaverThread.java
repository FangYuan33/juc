package life.fangyuan.juc.Balking;

import java.io.IOException;

/**
 * 定时保存的线程
 */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                // 要求保存数据
                data.save();
                // 休眠约1秒
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
