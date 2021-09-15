package study.io.对象流.序列化一个对象;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建学生对象
        Student s = new Student(1111, "liSi");
        // 创建一个对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\study\\io\\对象流\\student"));
        // 序列化
        oos.writeObject(s);
        // 刷新
        oos.flush();
        // 关闭
        oos.close();
    }
}
