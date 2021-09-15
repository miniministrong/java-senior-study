package study.io.标准输出流;

import java.io.*;

public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw.txt"))));
        pw.println("这是一段话");
        pw.println("这是第二段话");
        pw.flush();
    }
}