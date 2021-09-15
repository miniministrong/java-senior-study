package study.io.缓冲流;

import java.io.*;

/**
 * 使用BufferedWriter
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        /*FileWriter fileWriter = new FileWriter("src\\study\\io\\缓冲流\\copy");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);*/
        // 转换流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\study\\io\\缓冲流\\copy", true)));
        bufferedWriter.write("test");
        bufferedWriter.write("\n");
        bufferedWriter.write("008693");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}