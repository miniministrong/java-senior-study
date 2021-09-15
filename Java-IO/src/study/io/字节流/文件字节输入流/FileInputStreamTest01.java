package study.io.字节流.文件字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream的使用
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 创建FileInputStream文件字节输入流对象
            // 文件路径：D:\Study\02-Java\data.txt

            // 以下采用绝对路径的方式
            fileInputStream = new FileInputStream("D:\\Study\\02-Java\\data.txt");
            fileInputStream = new FileInputStream("D:/Study/02-Java/data.txt");

            // 开始读流
            int readData = fileInputStream.read();  // 返回值：读取到的字节本身
            System.out.println(readData);// 97

            readData = fileInputStream.read();
            System.out.println(readData);// 98

            readData = fileInputStream.read();
            System.out.println(readData);// 99

            readData = fileInputStream.read();
            System.out.println(readData);// 100

            readData = fileInputStream.read();
            System.out.println(readData);// 101

            readData = fileInputStream.read();
            System.out.println(readData);// 102
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在finally语句块当中要确保流一定关闭。
            // 关闭流的前提：流不为null。
            if (fileInputStream == null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
