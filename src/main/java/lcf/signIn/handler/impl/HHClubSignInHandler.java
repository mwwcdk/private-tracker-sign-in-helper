package lcf.signIn.handler.impl;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.stereotype.Component;

/**
 * 憨憨俱乐部 签到处理器
 */
@Component
public class HHClubSignInHandler implements SignInHandler {

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
        return "c_secure_uid=MTQ5MzA%3D; c_secure_pass=45d71e1d456e2c2faf659774555f4e83; c_secure_ssl=eWVhaA%3D%3D; c_secure_tracker_ssl=eWVhaA%3D%3D; c_secure_login=bm9wZQ%3D%3D; cf_clearance=A_swKvnYdomKRRdR2tBz6bZzAsyLQWOot_l9tiKzQM4-1693017652-0-1-fcbf4ff8.a8940a6a.4b38464a-160.0.0";
    }

}
