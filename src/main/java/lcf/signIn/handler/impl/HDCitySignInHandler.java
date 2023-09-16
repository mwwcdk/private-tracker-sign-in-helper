package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.stereotype.Component;

/**
 * 高清城市 签到处理器
 */
@Component
public class HDCitySignInHandler implements SignInHandler {

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

}
