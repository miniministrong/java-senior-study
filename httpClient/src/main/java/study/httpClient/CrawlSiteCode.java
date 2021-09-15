package study.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 使用httpClient爬取网站的源代码
 */
public class CrawlSiteCode {
    public static void main(String[] args){
        // 创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建GET请求对象
        HttpGet httpGet = new HttpGet("https://www.csdn.net");
        // 定义一个response
        CloseableHttpResponse response = null;
        try {
            // 执行Http协议的Get请求
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取返回实体，网页源代码
        HttpEntity entity = response.getEntity();
        try {
            // 获取网页内容
            System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
