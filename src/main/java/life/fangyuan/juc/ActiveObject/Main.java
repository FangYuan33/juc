package life.fangyuan.juc.ActiveObject;

import life.fangyuan.juc.ActiveObject.activeobject.ActiveObject;
import life.fangyuan.juc.ActiveObject.activeobject.ActiveObjectFactory;

public class Main {

    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();

        new DisplayClientThread("Chris", activeObject).start();
    }

}
