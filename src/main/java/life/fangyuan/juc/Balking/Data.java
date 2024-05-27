package life.fangyuan.juc.Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    // 保存的文件名称
    private final String filename;
    // 数据内容
    private String content;
    // 修改后的内容若未保存，则为true
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // 修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // 若数据内容修改过，则保存到文件中
    public synchronized void save() throws IOException {
        // 这里的判断和 return 相当于 balk 处理
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    // 将数据内容实际保存到文件中
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
