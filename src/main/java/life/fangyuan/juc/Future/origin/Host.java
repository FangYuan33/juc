package life.fangyuan.juc.Future.origin;

import life.fangyuan.juc.Future.Data;
import life.fangyuan.juc.Future.RealData;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 创建FutureData的实例
        final FutureData future = new FutureData();

        // (2) 启动一个新线程，用于创建RealData的实例
        new Thread(() -> {
            RealData realdata = new RealData(count, c);
            future.setRealData(realdata);
        }).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 返回FutureData的实例
        return future;
    }
}
