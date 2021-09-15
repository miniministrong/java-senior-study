package study.io.File;

import java.io.File;
import java.io.IOException;

public class FileTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\file");
        System.out.println(file.exists());
        // 判断是否存在这个文件，如果不存在则以文件的方式创建出来
        /*if (!file.exists()){
            file.createNewFile();
        }*/
        // 判断是否存在这个文件，如果不存在则以文件夹即目录的方式创建出来
        /*if (!file.exists()){
            file.mkdir();
        }*/
        // 判断是否存在这个文件，如果不存在，则以多重目录的形式创建出来
        File files = new File("D:\\a\\b\\c\\d\\e\\f\\g");
        /*if (!files.exists()){
            files.mkdirs();
        }*/
        File f3 = new File("C:\\MySQL\\mysql-8.0.25-winx64\\bin");
        System.out.println(f3.getParent());
        File parentFile = f3.getParentFile();
        System.out.println(parentFile.getAbsolutePath());
    }
}
