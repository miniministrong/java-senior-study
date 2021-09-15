package study.io.IO与Properties的联合使用;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * IO与Properties的联合使用
 */
public class IOPropertiesTest01 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src\\study\\io\\IO与Properties的联合使用\\userinfo.properties");
        Properties properties = new Properties();
        properties.load(reader);
        String username = properties.getProperty("username");
        System.out.println(username);
        String password = properties.getProperty("password");
        System.out.println(password);
    }
}
