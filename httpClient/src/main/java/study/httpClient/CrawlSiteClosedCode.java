package study.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 有些网站不让别人来爬取自己家的数据，这个时候我们可以使用java程序来模拟浏览器访问，只需要在里面添加User-Agent属性就可以了
 */
public class CrawlSiteClosedCode {
    public static void main(String[] args) {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 使用GET方法创建对象,并访问网站
        HttpGet httpGet = new HttpGet("https://www.csdn.net");
        // 设置我们模拟浏览器的参数
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67");
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        try {
            // 执行httpGet请求
            response = httpClient.execute(httpGet);
            // 获取我们访问网址时候的状态码
            System.out.println("Status:" + response.getStatusLine().getStatusCode());
            // 创建实体类，获取返回信息
            HttpEntity entity = response.getEntity();
            // 获取我们返回信息的Content-Type
            System.out.println("Content-Type:" + entity.getContentType().getValue());
            // 使用实体类工具，打印返回的信息，第一个参数是之前创建的实体类，用来获取信息，第二个参数是我们网站的字符编码，为了完整的显示网站内容，防止中文乱码
            // 输出我们获取的网站代码
            // System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
