package study.io.字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 对FileReader的使用
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("Reader");
            char[] chars = new char[5];
            int readCount = 0;
            while((readCount = reader.read(chars)) != -1){
                System.out.println(new String(chars, 0 , readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
