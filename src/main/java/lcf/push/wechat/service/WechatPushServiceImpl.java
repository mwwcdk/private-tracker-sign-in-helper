package lcf.push.wechat.service;

import lcf.SpringContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class WechatPushServiceImpl implements WechatPushService {

    @Override
    public void send(String title, String content) {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
        HttpGet httpGet = new HttpGet("http://iyuu.cn/IYUU29595T9d58ac94c98b73b7f33990a4abf629b847d0702e.send?text=" + title + "&desp=" + content);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response;
        try {
            response = SpringContext.getHttpClient().execute(httpGet);
        } catch (IOException e) {
            log.error("爱语飞飞推送消息异常!", e);
            return;
        }
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() == 200) {
            log.info("爱语飞飞消息推送成功! title:{}, content:{}", title, content);
            return;
        }
        log.error("爱语飞飞推送消息异常! {}", statusLine);
    }

}
