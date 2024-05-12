package life.fangyuan.juc.Future.origin;

import life.fangyuan.juc.Future.Data;
import life.fangyuan.juc.Future.RealData;

public class FutureData implements Data {

    private RealData realdata = null;

    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        if (ready) {
            return;
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realdata.getContent();
    }
}
