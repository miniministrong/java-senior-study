package study.io.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest02 {
    public static void main(String[] args) {
        File file = new File("D:\\SogouInput\\readme.txt");
        // 获取文件名
        System.out.println("文件名：" + file.getName());

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        long ms = file.lastModified();
        Date date = new Date(ms);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date));

        System.out.println(file.length());
    }
}
