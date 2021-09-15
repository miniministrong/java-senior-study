package study.io.缓冲流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader("src\\study\\io\\字符流\\FileReaderTest.java");
            bufferedReader = new BufferedReader(reader);
            String readStr = null;
            while ((readStr = bufferedReader.readLine()) != null){
                System.out.println(readStr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在关闭流的时候，我们不需要关闭节点流，只需要关闭包装流，因为包装流会帮我们把里面的节点流关闭
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
