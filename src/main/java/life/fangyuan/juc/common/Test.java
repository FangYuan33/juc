package life.fangyuan.juc.common;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.test01();
    }

    private void test01() throws InterruptedException {
        Synchronized aSynchronized = new Synchronized();

        new Thread(() -> {
            try {
                aSynchronized.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        aSynchronized.test2();
    }
}
