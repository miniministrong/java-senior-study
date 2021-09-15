package study.io.字节流.文件字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 使用了相对路径呢
            // IDEA默认的当前路径是在：工程的根
            // fileInputStream = new FileInputStream("data");
            // 如果文件存放在src下面
            // fileInputStream = new FileInputStream("src/data");
            // 如果文件存放在src/study/io中
            fileInputStream = new FileInputStream("src/study/io/data");

            // 开始读，采用byte数组，一次读取多个字节。最多读取“数组.length”个字节
            byte[] readDataBytes = new byte[4];
            // 这个方法的返回值是：读取到的字节数量（不是字节本身）
            int readCount = fileInputStream.read(readDataBytes);
            System.out.println(readCount);  // 第一次读到了4个字节。
            // 将字节数组全部转换成字符串
            // System.out.println(new String(readDataBytes)); // abcd
            // 不应该全部转换，应该是读取了多少个转换多少个
            System.out.println(new String(readDataBytes, 0, readCount));

            readCount = fileInputStream.read(readDataBytes);
            System.out.println(readCount); // 第二次读到了2个字节
            // System.out.println(new String(readDataBytes));  // efcd
            System.out.println(new String(readDataBytes, 0, readCount));

            readCount = fileInputStream.read(readDataBytes);
            System.out.println(readCount); // 一个都没有读到，返回-1
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
