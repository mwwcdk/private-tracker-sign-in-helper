package lcf.signIn.handler;

import lcf.signIn.constant.PrivateTrackerSite;

/**
 * 签到处理器
 */
public interface SignInHandler {

    /**
     * 获取站点
     * @return
     */
    PrivateTrackerSite getSite();

    void signIn();

}
