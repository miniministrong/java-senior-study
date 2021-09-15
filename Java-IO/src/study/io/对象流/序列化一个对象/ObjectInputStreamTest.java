package study.io.对象流.序列化一个对象;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 创建对象输入流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\study\\io\\对象流\\student"));
        // 反序列化对象
        Object o = ois.readObject();
        // 使用toString方法读取文件当中的数据
        System.out.println(o);
        // 关闭资源
        ois.close();
    }
}
