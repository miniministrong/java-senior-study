package study.io.字节流.文件字节输出流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            // 这种方式是先将源文件的内容清空，再写入。但是如果没有源文件的话，那就会创建源文件
            // fileOutputStream = new FileOutputStream("myData");
            // 这种方式如果后面的append值为true的话，是将源文件不做清空处理，直接在后面写入
            fileOutputStream = new FileOutputStream("myData", true);
            byte[] bytes = {97, 98, 99, 100, 101, 102};
            // 将这个数组写入文件中
            fileOutputStream.write(bytes);
            // 将这个数组的部分数据写入文件
            fileOutputStream.write(bytes, 0, 2);

            String s = "这是一段话";
            // 将这段字符串转为byte数组
            byte[] strbytes = s.getBytes();
            // 再写入到文件当中去
            fileOutputStream.write(strbytes);
            // 记得一定要刷新
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
