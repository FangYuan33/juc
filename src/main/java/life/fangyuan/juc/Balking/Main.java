package life.fangyuan.juc.Balking;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        // 用户线程
        new ChangerThread("ChangerThread", data).start();
        // 定时保存的线程
        new SaverThread("SaverThread", data).start();
    }
}
