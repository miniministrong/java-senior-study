package study.io.文件复制;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用FileInputStream和FileOutputStream来拷贝我们的文件
 */
public class CopyTest01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建一个文件输入流
            fis = new FileInputStream("D:\\Study\\02-Java\\资料\\io流\\javaIO.mp4");
            // 创建一个文件输出流
            fos = new FileOutputStream("C:\\Users\\EBIZ\\Desktop\\javaIO.mp4", true);
            // 一边读，一边写
            // 准备一个1MB的数组用来存储数据，我们拷贝是一次拷贝1MB
            byte[] bytes = new byte[1024 * 1024];
            // 数据读取的长度
            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1){
                // 边读 边写
                fos.write(bytes, 0 , readCount);
            }
            // 刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭的时候一定要分开try...catch
            // 因为如果不分开try...catch的话，万一我们某个流出现错误了，可能会导致另外一个流无法关闭。
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
