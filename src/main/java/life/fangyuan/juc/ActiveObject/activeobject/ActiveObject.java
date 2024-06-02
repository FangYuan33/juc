package life.fangyuan.juc.ActiveObject.activeobject;

public interface ActiveObject {

    Result<String> makeString(int count, char fillChar);

    void displayString(String string);
}
