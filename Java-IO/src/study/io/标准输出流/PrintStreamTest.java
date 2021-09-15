package study.io.标准输出流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 标准输出流
 */
public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        ps.println("hello world");

        PrintStream printStream = new PrintStream(new FileOutputStream("printStream.txt", true));
        System.setOut(printStream);
        printStream.println("hello world");
        printStream.flush();

    }
}
