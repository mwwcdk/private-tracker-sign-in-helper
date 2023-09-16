package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.stereotype.Component;

/**
 * 瓷器 签到处理器
 */
@Component
public class HDChinaSignInHandler implements SignInHandler {

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.HDChina;
    }

    @Override
    public String getURI() {
        return "https://hdchina.org/plugin_sign-in.php?cmd=signin";
    }

    @Override
    public String getCookie() {
        return "hdchina=f14f1a133a34694fb0234e8e59305bab6f78f0ba02bef1563b20ae471d5f48b6; PHPSESSID=s51l07mrvkkm9ju4rnk8ghc4ph";
    }

}
