package lcf;

import io.netty.channel.EventLoopGroup;
import lcf.push.wechat.service.WechatPushService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Spring上下文
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static SpringContext instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }

    /** 事件执行器 */
    @Autowired
    private EventLoopGroup eventLoopGroup;

    public static EventLoopGroup getEventLoopGroup() {
        return instance.eventLoopGroup;
    }

    /** 微信推送服务 */
    @Autowired
    private WechatPushService wechatPushService;

    public static WechatPushService getWechatPushService() {
        return instance.wechatPushService;
    }

    /** HTTP客户端 */
    @Autowired
    private CloseableHttpClient httpClient;

    public static CloseableHttpClient getHttpClient() {
        return instance.httpClient;
    }

}
