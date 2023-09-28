package lcf.signIn.handler;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.model.SignInResult;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 签到处理器
 */
public interface SignInHandler {

    static final Logger LOGGER = LoggerFactory.getLogger(SignInHandler.class);

    /**
     * 获取站点
     * @return
     */
    PrivateTrackerSite getSite();

    /**
     * 签到
     *
     * @return
     */
    default SignInResult signIn() throws IOException {
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
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response;
        response = httpClient.execute(httpGet);
        // HTTP响应的实体字符串
        String responseEntity = EntityUtils.toString(response.getEntity());
        // 处理HTTP响应
        return handleHttpResponse(response, responseEntity);
    }

    /**
     * 处理HTTP响应
     *
     * @param httpResponse
     * @param responseEntity
     * @return
     */
    default SignInResult handleHttpResponse(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        SignInResult result = new SignInResult();

//        LOGGER.info("{}的response:{}", getSite(), responseEntity);

        // 失败
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            result.setSuccess(false);
            result.setTips(httpResponse.getStatusLine().getStatusCode() + " " + httpResponse.getStatusLine().getReasonPhrase());
            return result;
        }
        // 成功
        result.setSuccess(true);
        result.setTips(getSuccessTips(httpResponse, responseEntity));
        return result;
    }

    /**
     * 获取签到成功的提示
     *
     * @param httpResponse
     * @param responseEntity
     * @return
     */
    default String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        return responseEntity;
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
