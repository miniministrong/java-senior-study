package study.io.标准输出流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void log(String msg){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("log.txt", true));
            System.setOut(ps);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
            String format = sdf.format(date);

            System.out.println(format + " : " + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
