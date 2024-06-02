package life.fangyuan.juc.ThreadSpecificStorage.sample2;

public class Log {

    // 先创建出一个储物柜，供每个线程存放自己的日志处理器
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    // 写日志
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 关闭日志
    public static void close() {
        getTSLog().close();
    }

    // 获取线程特有的日志
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // 如果该线程是第一次调用本方法，就新生成并注册一个日志
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
