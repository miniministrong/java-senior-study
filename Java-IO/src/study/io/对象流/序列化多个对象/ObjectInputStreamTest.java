package study.io.对象流.序列化多个对象;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\study\\io\\对象流\\序列化多个对象\\users"));
        List<User> userList = (List<User>) ois.readObject();
        for (User users : userList){
            System.out.println(users);
        }
        ois.close();
    }
}
