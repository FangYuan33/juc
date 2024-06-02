package life.fangyuan.juc.ActiveObject.activeobject;

class Servant implements ActiveObject {

    // 拼接字符串
    public Result<String> makeString(int count, char fillChar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = fillChar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }
        return new RealResult<>(new String(buffer));
    }

    // 显示字符串
    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
