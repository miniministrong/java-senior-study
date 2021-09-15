package study.io.字符流;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Writer", true);
            char[] chars = {'这', '是', '一', '个', '字'};
            fileWriter.write(chars);
            // 还可以在write方法中直接输入
            fileWriter.write("这是什么");
            // 换行
            fileWriter.write("\n");
            fileWriter.write("nice");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
