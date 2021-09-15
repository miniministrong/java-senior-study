package practice;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * 使用IO流和httpClient将网站上的图片拷贝下来
 */
public class MySelfCopyPictureToLocationPath {
    // 图片所在的网络地址
    public static final String IMG_WEB_URL = "https://img2.baidu.com/it/u=1678948314,1083480950&fm=26&fmt=auto&gp=0.jpg";
    // 所要存储的本地位置
    public static final String IMG_LOCATION_PATH = "D:\\image.jpg";
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = createHttpClientConnection();
            CopyWebToLocation(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建HttpClient对象并对文件中的数据进行操作
     * @return 字节输入流
     * @throws IOException
     */
    public static InputStream createHttpClientConnection() throws IOException {
        // 创建可关闭的HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建Get方法
        HttpGet httpGet = new HttpGet(IMG_WEB_URL);
        // 使用Get方法对网站进行访问
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 将数据存储在实体类当中
        HttpEntity entity = response.getEntity();
        return entity.getContent();
    }

    /**
     * 将流中的数据拷贝到本地
     * @param in 流
     */
    public static void CopyWebToLocation(InputStream in){
        OutputStream out = null;
        try {
            out = new FileOutputStream(IMG_LOCATION_PATH);
            int readCount = 0;
            byte[] bytes = new byte[1024];
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}