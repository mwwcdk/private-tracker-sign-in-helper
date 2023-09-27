package lcf;

import ch.qos.logback.core.util.TimeUtil;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import lcf.application.ShutdownHook;
import lcf.signIn.constant.PrivateTrackerSite;
import lcf.signIn.handler.impl.*;
import lcf.signIn.model.SignInResult;
import lcf.signIn.service.SignInService;
import lcf.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 程序入口类
 */
@Slf4j
@SpringBootApplication
public class Main {

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        try {
            log.info("程序开始启动...");
            long startTime = System.currentTimeMillis();
            SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Main.class, SpringContext.class);
            springApplicationBuilder.main(Main.class);
            springApplicationBuilder.run(args);
            // 添加程序关闭钩子
            Runtime.getRuntime().addShutdownHook(new ShutdownHook());
            log.info("恭喜 程序启动成功! 耗时:{}ms", System.currentTimeMillis() - startTime);

            SignInResult signInResult = SpringContext.getApplicationContext().getBean(HHClubSignInHandler.class).signIn();
            log.info("站点:{} \n签到结果:{}\n{}", PrivateTrackerSite.HHClub, signInResult.isSuccess()? "成功" : "失败", signInResult.getTips());


        } catch (Throwable e) {
            log.error("程序启动失败o(╥﹏╥)o", e);
            Runtime.getRuntime().exit(1);
        }
    }

}
