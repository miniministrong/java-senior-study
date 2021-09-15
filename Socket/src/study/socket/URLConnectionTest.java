package study.socket;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 发送http请求
public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        // 创建URL
        String urlName;
        if (args.length > 0) {
            urlName = args[0];
        } else {
            urlName = "https://horstmann.com";
        }
        URL url = new URL(urlName);
        // 打开连接
        URLConnection connection = url.openConnection();
        if (args.length > 2) {
            String username = args[1];
            String password = args[2];
            String input = username + ":" + password;
            String encoding = MimeUtility.encodeText(input, null, "base64");
            connection.setRequestProperty("Authorization", "Basic" + encoding);
        }
        connection.connect();
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                System.out.println(key + ":" + value);
            }
        }
        System.out.println("---------------------");
        // 获取目标网址的内容类型：text/html
        System.out.println("getContentType:" + connection.getContentType());
        // 获取目标网址的内容长度：6356
        System.out.println("getContentLength:" + connection.getContentLength());
        // 获取目标网址的内容字符串编码
        System.out.println("getContentEncoding:" + connection.getContentEncoding());
        // 获取的是URL引用的资源的发送日期，相当于到你访问这个网址的时间，采用的是从1970年1月1日0时0分0秒开始计算的毫秒数
        System.out.println("getDate:" + connection.getDate());
        // 获取的是URL请求头中数据的过期时间
        System.out.println("getExpiration:" + connection.getExpiration());
        // 获取目标网址的最后更新日期，采用的是从1970年1月1日0时0分0秒开始计算的毫秒数
        System.out.println("getLastModified:" + connection.getLastModified());
        System.out.println("---------------------------");
        // 打印出当前网址页面的代码
        InputStream in = connection.getInputStream();
        Scanner sc = new Scanner(in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}