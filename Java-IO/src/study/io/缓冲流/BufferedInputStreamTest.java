package study.io.缓冲流;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("data"));
        /*int readCount = 0;
        while((readCount = bufferedInputStream.read()) != -1){
            System.out.println((char)readCount);
        }*/

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, length));
        }
        bufferedInputStream.close();
    }
}
