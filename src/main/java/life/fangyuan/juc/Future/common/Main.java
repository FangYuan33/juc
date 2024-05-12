package life.fangyuan.juc.Future.common;

import life.fangyuan.juc.Future.RealData;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main BEGIN");

        // 创建固定大小的线程池
        try (ExecutorService threadPool = Executors.newFixedThreadPool(5)) {

            Future<String> future = threadPool.submit(() -> new RealData(10, 'A').getContent());
            Future<String> future2 = threadPool.submit(() -> new RealData(10, 'B').getContent());
            Future<String> future3 = threadPool.submit(() -> new RealData(10, 'C').getContent());

            System.out.println("main otherJob BEGIN");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("main otherJob END");

            System.out.println("data1 = " + future.get());
            System.out.println("data2 = " + future2.get());
            System.out.println("data3 = " + future3.get());
        }
    }
}
