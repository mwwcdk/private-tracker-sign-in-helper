package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 馒头 签到处理器
 */
@Component
public class MTeamSignInHandler implements SignInHandler {

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
    public String getSuccessTips(CloseableHttpResponse httpResponse) throws IOException {
        return "提示:馒头无签到功能, 访问主页避免封号";
    }

}
