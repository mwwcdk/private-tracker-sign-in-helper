package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 高清城市 签到处理器
 */
@Component
public class HDCitySignInHandler implements SignInHandler {

    /** 用于从HTTP响应中提取信息的正则表达式 */
    private static final Pattern PATTERN = Pattern.compile("<h1><span class=\"colored\">今天已经签过到~</span> 今日签到时幸运地获得 .* 魅力值。</h1>");

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.HDCity;
    }

    @Override
    public String getURI() {
        return "https://hdcity.city/sign";
    }

    @Override
    public String getCookie() {
        return "c_lang_folder=chs; c_secure_uid=MTAxMDI5NzE%3D; c_secure_pass=39c471f55c47b2d7beec53c6ec671313; c_secure_ssl=bm9wZQ%3D%3D; c_secure_tracker_ssl=bm9wZQ%3D%3D; c_secure_login=bm9wZQ%3D%3D";
    }

    @Override
    public String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        Matcher matcher = PATTERN.matcher(responseEntity);
        if (matcher.find()) {
            return matcher.group(0).replaceAll("<h1><span class=\"colored\">今天已经签过到~</span> ", "").replaceAll("。</h1>", "");
        }
        return "";
    }

}
