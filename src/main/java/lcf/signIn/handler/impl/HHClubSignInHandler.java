package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 憨憨俱乐部 签到处理器
 */
@Component
public class HHClubSignInHandler implements SignInHandler {

    /** 用于从HTTP响应中提取信息的正则表达式 */
    private static final Pattern PATTERN = Pattern.compile("这是您的第.*次签到，已连续签到.*天，本次签到获得.*个憨豆。");

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.HHClub;
    }

    @Override
    public String getURI() {
        return "https://hhanclub.top/attendance.php";
    }

    @Override
    public String getCookie() {
        return "c_secure_uid=MTQ5MzA%3D; c_secure_pass=45d71e1d456e2c2faf659774555f4e83; c_secure_ssl=eWVhaA%3D%3D; c_secure_tracker_ssl=eWVhaA%3D%3D; c_secure_login=bm9wZQ%3D%3D; cf_clearance=J5wf7v1iiSPurZ.w1cUmxq_C651uShheFDONcBcC7rk-1694886513-0-1-fc0827bb.4741ad28.a4ede108-160.0.0";
    }

    @Override
    public String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        Matcher matcher = PATTERN.matcher(responseEntity);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

}
