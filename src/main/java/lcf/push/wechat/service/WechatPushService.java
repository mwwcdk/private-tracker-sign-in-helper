package lcf.push.wechat.service;

/**
 * 微信推送服务
 */
public interface WechatPushService {

    /**
     * 发消息
     * @param title 标题
     * @param content 内容
     */
    void send(String title, String content);

}
