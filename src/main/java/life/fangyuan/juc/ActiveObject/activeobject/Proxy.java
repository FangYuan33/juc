package life.fangyuan.juc.ActiveObject.activeobject;

class Proxy implements ActiveObject {
    
    private final SchedulerThread scheduler;
    
    private final Servant servant;
    
    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int count, char fillChar) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant, future, count, fillChar));

        return future;
    }

    @Override
    public void displayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant, string));
    }
}
