package life.fangyuan.juc.ActiveObject.activeobject;

public class ActiveObjectFactory {
    public static ActiveObject createActiveObject() {
        // 仆人
        Servant servant = new Servant();
        // 队列
        ActivationQueue queue = new ActivationQueue();
        // 创建调度线程：在队列中放入和取出 MethodRequest 执行
        SchedulerThread scheduler = new SchedulerThread(queue);
        Proxy proxy = new Proxy(scheduler, servant);
        scheduler.start();

        return proxy;
    }
}
