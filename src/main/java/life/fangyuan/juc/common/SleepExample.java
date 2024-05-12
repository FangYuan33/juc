package life.fangyuan.juc.common;

public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Start");
        try {
            Thread.sleep(2000);  // 暂停2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
