package study.httpClient;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 从网站上选择选择好的图片进行保存在本地的操作
 */
public class TakePicture {
    public static void main(String[] args) {
        // 目标网址
        String url = "https://img0.baidu.com/it/u=2135557883,423992380&fm=26&fmt=auto&gp=0.jpg";
        // 创建可关闭的HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建Get请求，将目标网址贴过去
        HttpGet httpGet = new HttpGet(url);
        // 创建一个Response对象
        CloseableHttpResponse response = null;
        try {
            // 执行我们的Get请求
            response = httpClient.execute(httpGet);
            // 创建一个实体类,获取我们当前信息中的所有信息，存储到实体类当中去。
            HttpEntity entity = response.getEntity();
            System.out.println("Content-Type:" + entity.getContentType().getValue());
            // 将我们网站上面的图片存储成为一个流
            InputStream in = entity.getContent();
            // 利用commons-io库将我们网站上面的图片存储下来
            FileUtils.copyToFile(in, new File("D:\\header.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
