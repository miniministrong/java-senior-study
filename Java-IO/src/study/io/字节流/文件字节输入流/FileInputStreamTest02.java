package study.io.字节流.文件字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 新建一个FileInputStream的对象
            fileInputStream = new FileInputStream("D:\\Study\\02-Java\\data.txt");
            /*while(true){
                // 读取文件内的字节，返回一个数值
                int readData = fileInputStream.read();
                // 如果读取到的数是-1的话，那就代表文件内没有数据可以读了。
                if (readData == -1){
                    break;
                }
                System.out.println(readData);
            }*/

            // 改良while循环
            int readData = 0;
            while ((readData = fileInputStream.read()) != -1){
                System.out.println(readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 判断流是否为空，为空则关闭流
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
