package lcf.signIn.handler;

import lcf.signIn.constant.PrivateTrackerSite;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 签到处理器
 */
public interface SignInHandler {

    /**
     * 获取站点
     * @return
     */
    PrivateTrackerSite getSite();

    /**
     * 签到
     */
    default void signIn() throws IOException {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
        HttpGet httpGet = new HttpGet(getURI());
        httpGet.setConfig(requestConfig);
        httpGet.addHeader(":method", "GET");
        httpGet.addHeader(":path", "/index.php");
        httpGet.addHeader(":scheme", "https");
        httpGet.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpGet.addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,und;q=0.6");
        httpGet.addHeader("cache-control", "max-age=0");
        httpGet.addHeader("cookie", getCookie());
        httpGet.addHeader("sec-fetch-dest", "document");
        httpGet.addHeader("sec-fetch-mode", "navigate");
        httpGet.addHeader("sec-fetch-site", "none");
        httpGet.addHeader("sec-fetch-user", "?1");
        httpGet.addHeader("upgrade-insecure-requests", "1");
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response;
        response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(getSite() + " 签到成功");
        } else {
            System.out.println(getSite() + "\t签到出现异常 未签到成功\t" + response.getStatusLine().getStatusCode());
        }
    }

    /**
     * 获取统一资源标识符
     * @return
     */
    String getURI();

    /**
     * 获取饼干
     * @return
     */
    String getCookie();

}
