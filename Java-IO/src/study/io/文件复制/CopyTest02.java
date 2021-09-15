package study.io.文件复制;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用FileReader和FileWriter对文本文档进行拷贝
 */
public class CopyTest02 {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            // 读
            reader = new FileReader("D:\\Study\\01-MySQL\\作业题.txt");
            // 写
            writer = new FileWriter("C:\\Users\\EBIZ\\Desktop\\作业题.txt", true);
            // 创建一个char数组用来存放数据，大小为1MB
            char[] chars = new char[1024 * 512];
            int readCount = 0;
            while((readCount = reader.read(chars)) != -1){
                writer.write(chars, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
