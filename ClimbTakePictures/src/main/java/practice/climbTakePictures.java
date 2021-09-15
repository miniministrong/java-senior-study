package practice;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网上的
 */
public class climbTakePictures {

    public static void main(String[] args) {
        // 定义我们图片资源地址
        String imgUrl = "https://img0.baidu.com/it/u=3311900507,1448170316&fm=26&fmt=auto&gp=0.jpg";
        // 定义图片存放位置以及图片的命名
        String imgLocationPath = "D:\\image.jpg";
        try {
            InputStream in = AccessToResources(imgUrl);
            PictureToFile(in, imgLocationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static InputStream AccessToResources(String webPath) throws IOException {
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(webPath);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                inputStream = urlConnection.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void PictureToFile(InputStream inputStream, String url) throws IOException {
        InputStream in = inputStream;
        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(url);
            while ((len = in.read(data)) != -1) {
                out.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
