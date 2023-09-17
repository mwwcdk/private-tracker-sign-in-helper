package lcf.signIn.service;

import lcf.SpringContext;
import lcf.signIn.model.SignInResult;
import lcf.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class SignInServiceImpl implements SignInService, SmartLifecycle {

    @Autowired
    private SignInManager manager;

    @Override
    public void signIn() {
        log.info("开始执行今天的签到任务...");
        manager.getHandlers().forEach(handler -> {
            try {
                SignInResult result = handler.signIn();
                log.info("站点:{} \n签到结果:{}\n{}", handler.getSite(), result.isSuccess()? "成功" : "失败", result.getTips());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("今天的签到任务执行完成!");
    }

    @Override
    public void start() {
        long nextSignTime = TimeUtils.getNextTime("0 5 0 * * ?");
        log.info("下次执行签到任务的时间:{}", TimeUtils.format(nextSignTime));
        // 这里使用了Netty提供的事件循环组, 用于做定时调度
        SpringContext.getEventLoopGroup().scheduleAtFixedRate(() -> {
            try {
                // 签到
                signIn();
                log.info("下次执行签到任务的时间:{}", TimeUtils.format(System.currentTimeMillis() + TimeUtils.ONE_DAY_MILLIS));
            } catch (Exception e) {
                log.error("定时任务执行异常", e);
            }
        }, nextSignTime - System.currentTimeMillis(), TimeUtils.ONE_DAY_MILLIS, TimeUnit.MILLISECONDS);
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

}
