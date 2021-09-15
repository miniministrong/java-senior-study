package study.io.字节流.文件字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * long	skip(long n)：跳过几个字节不读
 */
public class FileInputStreamTest06 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\Study\\02-Java\\data.txt");
            byte[] bytes = new byte[fileInputStream.available()];
            System.out.println("可读取到的总数量：" + fileInputStream.available());
            fileInputStream.skip(2);
            System.out.println("剩余的数量：" + fileInputStream.available());
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
