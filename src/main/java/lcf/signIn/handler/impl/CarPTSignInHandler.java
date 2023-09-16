package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.stereotype.Component;

/**
 * 小车站 签到处理器
 */
@Component
public class CarPTSignInHandler implements SignInHandler {

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

}
