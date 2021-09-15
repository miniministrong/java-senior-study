package study.io.File;

import java.io.File;

public class FileTest03 {
    public static void main(String[] args) {
        File file = new File("D:\\SogouInput");
        File[] files = file.listFiles();
        for (File f : files) {
            // System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
        }
    }
}
