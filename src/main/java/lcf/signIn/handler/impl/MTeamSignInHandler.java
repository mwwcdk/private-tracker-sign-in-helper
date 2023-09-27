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
 * 馒头 签到处理器
 */
@Component
public class MTeamSignInHandler implements SignInHandler {

    /** 用于从HTTP响应中提取信息的正则表达式 */
    private static final Pattern PATTERN = Pattern.compile(">使用</a>]: .* <font class = ");

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.MTeam;
    }

    @Override
    public String getURI() {
        return "https://kp.m-team.cc/";
    }

    @Override
    public String getCookie() {
        return "cf_clearance=ZctOq4K8Aevd2W0b5ZQWltuojhGwMRNPwvrj6oAf..o-1693059288-0-1-6cbdefbb.47d118e0.a47d54c0-160.0.0; tp=NzYxNWYwMDU1MjQyNjcwNGE1YzY0OTU2NGVmNmE1N2NlNzcxYzgyNw%3D%3D";
    }

    @Override
    public String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
        Matcher matcher = PATTERN.matcher(responseEntity);
        if (matcher.find()) {
            return "当前魔力值:" + matcher.group(0).replaceAll(">使用</a>]: ", "").replaceAll(" <font class = ", "");
        }
        return "";
    }

}
