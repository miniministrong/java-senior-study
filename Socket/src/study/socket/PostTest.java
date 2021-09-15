package study.socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PostTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        String s = File.separator;
        InputStream in = null;
        try {
            in = PostTest.class.getResourceAsStream("study/socket/data.properties");
            props.load(in);
            String url = props.remove("url").toString();
            String result = doPost(url, props);
            System.out.println("----------------");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static String doPost(String urlString, Properties props) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        boolean first = true;
        for (Map.Entry<Object, Object> pair : props.entrySet()) {
            if (first) {
                first = false;
            } else {
                out.print("&");
            }
            String name = pair.getKey().toString();
            String value = pair.getValue().toString();
            out.print(name);
            out.print("=");
            out.print(URLEncoder.encode(value, "UTF-8"));
        }
        StringBuilder response = new StringBuilder();
        try {
            Scanner sc = new Scanner(connection.getInputStream());
            while (sc.hasNextLine()) {
                response.append(sc.nextLine());
                response.append("\n");
            }
        } catch (IOException e) {
            if (!(connection instanceof HttpURLConnection)) {
                throw e;
            }
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (err == null) {
                throw e;
            }
            System.out.println("error");
            Scanner sc = new Scanner(err);
            response.append(sc.nextLine());
            response.append("\n");
        }
        return response.toString();
    }
}