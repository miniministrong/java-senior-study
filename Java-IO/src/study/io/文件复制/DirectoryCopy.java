package study.io.文件复制;

import java.io.*;

public class DirectoryCopy {
    public static void main(String[] args) {
        // 拷贝源
        File srcFile = new File("D:\\Study");
        // 拷贝目标
        File destFile = new File("C:\\Users\\EBIZ\\Desktop\\1");
        // 拷贝方法
        copyDir(srcFile, destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        // 如果源文件是一个文件时，我们就需要对文件进行拷贝并且终止当前循环
        if (srcFile.isFile()){
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new FileInputStream(srcFile);
                // 定义一个输出文件的路径，使用字符串拼接的方式来完成我们路径的拼接，因为我们需要用到字符串截取的方法，
                // 我们可能会将D:\替换成C:\，因此我们需要通过字符串拼接，截取来找到我们的路径
                String path = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\")
                        + srcFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(path);
                // 一边读一边写
                byte[] bytes = new byte[1024 * 1024]; // 1MB
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    out.write(bytes, 0 , readCount);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        // 获取当前目录下的所有子目录以及文件
        File[] files = srcFile.listFiles();
        // 遍历数组，使之完成递归操作
        for (File file : files) {
            // 判断当前文件是否为目录，如果是目录则进行下一步操作，如果不是，则继续查找下一个文件
            if (file.isDirectory()) {
                // 当前文件的文件源路径（绝对地址）
                String srcDir = file.getAbsolutePath();
                // 目标文件的路径地址，是通过我们目标路径在进行字符串拼接的方式来拼接成为我们新的路径
                String destDir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\") +
                        srcDir.substring(3);
                File newFile = new File(destDir);
                // 如果新建好的这个目录不存在的话，就要创建当前路径，如果存在则跳过
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
            }
            // 递归调用
            copyDir(file, destFile);
        }
    }
}