package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.stereotype.Component;

/**
 * PT时间 签到处理器
 */
@Component
public class PTTimeSignInHandler implements SignInHandler {

    @Override
    public PrivateTrackerSite getSite() {
        return PrivateTrackerSite.PTT;
    }

    @Override
    public String getURI() {
        return "https://www.pttime.org/attendance.php?uid=81799";
    }

    @Override
    public String getCookie() {
        return "c_secure_uid=ODE3OTk%3D; c_secure_pass=d7f3a6a3bc871e99cd12364e385d92fc; c_secure_ssl=eWVhaA%3D%3D; c_secure_tracker_ssl=eWVhaA%3D%3D; c_secure_login=bm9wZQ%3D%3D; cf_clearance=4Ka8ir68RciFFZZ0csnZFryN0b3VL0YTlvlZno_NPoI-1694886769-0-1-fc0827bb.4741ad28.a4ede108-0.2.1694886769";
    }

}
