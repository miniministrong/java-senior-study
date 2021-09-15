package study.io.对象流.序列化多个对象;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "zhangSan"));
        userList.add(new User(2, "liSi"));
        userList.add(new User(3, "wangWu"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\study\\io\\对象流\\序列化多个对象\\users"));
        // 序列化一个集合
        oos.writeObject(userList);
        oos.flush();
        oos.close();
    }
}
