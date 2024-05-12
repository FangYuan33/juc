package life.fangyuan.juc.Future.common;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Example {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 预定蛋糕，并定义“提货单”
        System.out.println("我：预定蛋糕");
        FutureTask<String> future = new FutureTask<>(() -> {
            System.out.println("店员：请您傍晚来取蛋糕");
            Thread.sleep(2000);
            System.out.println("店员：您的蛋糕已经做好了");

            return "Holiland";
        });
        // 开始做蛋糕
        new Thread(future).start();

        // 我去做其他事情
        Thread.sleep(1500);
        System.out.println("我：忙碌中...");
        // 取蛋糕
        System.out.println("我：取蛋糕 " + future.get());
    }
}
