package lcf.signIn.service;

import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.SignInHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 签到 管理器
 */
@Component
public class SignInManager {

    /**
     * PT站 -> 签到处理器
     */
    private Map<PrivateTrackerSite, SignInHandler> site2Handler;

    /**
     * 初始化 PT站->签到处理器
     */
    @Autowired
    private void initSite2Handler(Set<SignInHandler> handlers) {
        Map<PrivateTrackerSite, SignInHandler> site2Handler = new HashMap<>();
        handlers.forEach(handler -> {
            if (site2Handler.put(handler.getSite(), handler) != null) {
                throw new IllegalStateException("SignInHandler发现重复的site! repeatedSite:" + handler.getSite());
            }
        });
        this.site2Handler = site2Handler;
    }

    /**
     * 获取所有PT站的签到处理器
     * @return
     */
    public Collection<SignInHandler> getHandlers() {
        return site2Handler.values();
    }

}
