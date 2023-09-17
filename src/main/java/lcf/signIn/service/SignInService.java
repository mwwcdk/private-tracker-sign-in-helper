package lcf.signIn.service;

/**
 * 签到服务
 */
public interface SignInService {

    /**
     * 每日需要执行的真实签到逻辑
     */
    void signIn();

}
