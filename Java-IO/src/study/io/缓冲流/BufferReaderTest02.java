package study.io.缓冲流;

import java.io.*;

/**
 * 使用InputStreamReader将字节流转换为字符流
 */
public class BufferReaderTest02 {
    public static void main(String[] args) {
        /*FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;*/
        BufferedReader bufferedReader = null;
        try {
            /*fileInputStream = new FileInputStream("src\\study\\io\\字符流\\FileReaderTest.java");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);*/
            // 合并
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\study\\io\\字符流\\FileReaderTest.java")));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
