package study.io.字节流.文件字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 最终版本的字节输入流
 */
public class FileInputStreamTest04 {
    public static void main(String[] args) {
        // 创建文件输入流类
        FileInputStream fileInputStream = null;
        try {
            // 创建一个文件输入流对象
            fileInputStream = new FileInputStream("D:\\Study\\02-Java\\data.txt");
            // 创建一个数组用来存放我们在文件中读取到的数据
            byte[] readData = new byte[4];
            // 我们发现当前的循环是比较无意义的
            /*while(true){
                // 定义一个变量用来存放读取到的数据的个数
                int readCount = fileInputStream.read(readData);
                // 判断：如果读取到的数据为-1则证明文件中没有数据，则需要结束循环
                if (readCount == -1){
                    break;
                }
                // 将我们从文件中读取到的数据转换为String类型的字符串，然后将其输出
                System.out.print(new String(readData, 0, readCount));
            }*/
            // 定义一个整数型变量用来存放我们读取到数据的个数
            int readCount = 0;
            // 判断：当读取到的个数不为-1时，则表示数组当中有数据，我们就可以对其进行输出
            while ((readCount = fileInputStream.read(readData)) != -1){
                System.out.print(new String(readData, 0, readCount));
            }
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