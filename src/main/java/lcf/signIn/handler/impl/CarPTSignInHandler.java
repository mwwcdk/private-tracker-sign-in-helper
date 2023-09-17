package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小车站 签到处理器
 */
@Component
@Slf4j
public class CarPTSignInHandler implements SignInHandler {

    /** 用于从HTTP响应中提取信息的正则表达式 */
    private static final Pattern PATTERN = Pattern.compile("<p>这是您的第 <b>.*</b> 个魔力值。");

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.CarPT;
    }

    @Override
    public String getURI() {
        return "https://carpt.net/attendance.php";
    }

    @Override
    public String getCookie() {
        return "c_secure_uid=MTE2ODA%3D; c_secure_pass=e2c08b5a5f3b50cc57bb5d3f49b98ed1; c_secure_ssl=eWVhaA%3D%3D; c_secure_tracker_ssl=eWVhaA%3D%3D; c_secure_login=bm9wZQ%3D%3D; cf_clearance=C4QBEx5oA_IQ.PlbYrN9t_hDSDsg.IcwOmikQ7cD.44-1689957346-0-160.0.0";
    }

    @Override
    public String getSuccessTips(CloseableHttpResponse httpResponse) throws IOException {
        Matcher matcher = PATTERN.matcher(EntityUtils.toString(httpResponse.getEntity()));
        if (matcher.find()) {
            return matcher.group(0).replaceAll("<p>", "").replaceAll("<b>", "").replaceAll("</b>", "").replaceAll(" ", "");
        }
        return "";
    }

}
