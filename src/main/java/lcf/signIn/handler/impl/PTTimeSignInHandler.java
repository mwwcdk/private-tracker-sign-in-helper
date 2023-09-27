package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PT时间 签到处理器
 */
@Component
public class PTTimeSignInHandler implements SignInHandler {

    /** 用于从HTTP响应中提取信息的正则表达式 */
    private static final Pattern PATTERN = Pattern.compile("这是你的第 <b>.*</b> 个魔力值。");

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.PTT;
    }

    @Override
    public String getURI() {
        return "https://www.pttime.org/attendance.php";
    }

    @Override
    public String getCookie() {
        return "c_secure_uid=ODE3OTk%3D; c_secure_pass=d7f3a6a3bc871e99cd12364e385d92fc; c_secure_ssl=eWVhaA%3D%3D; c_secure_tracker_ssl=eWVhaA%3D%3D; c_secure_login=bm9wZQ%3D%3D; cf_clearance=4Ka8ir68RciFFZZ0csnZFryN0b3VL0YTlvlZno_NPoI-1694886769-0-1-fc0827bb.4741ad28.a4ede108-0.2.1694886769";
    }

    @Override
    public String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        Matcher matcher = PATTERN.matcher(responseEntity);
        if (matcher.find()) {
            return matcher.group(0).replaceAll("<b> ", "").replaceAll("</b>", "");
        }
        return "";
    }

}
