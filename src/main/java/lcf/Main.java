package lcf;

import ch.qos.logback.core.util.TimeUtil;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import lcf.application.ShutdownHook;
import lcf.signIn.handler.impl.HDChinaSignInHandler;
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

            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            HttpGet httpGet = new HttpGet("http://iyuu.cn/IYUU29595T9d58ac94c98b73b7f33990a4abf629b847d0702e.send?text=gaga&desp=huohahahha");
            httpGet.setConfig(requestConfig);
//            httpGet.addHeader(":method", "GET");
//            httpGet.addHeader(":path", "/index.php");
//            httpGet.addHeader(":scheme", "https");
//            httpGet.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//            httpGet.addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,und;q=0.6");
//            httpGet.addHeader("cache-control", "max-age=0");
////            httpGet.addHeader("cookie", getCookie());
//            httpGet.addHeader("sec-fetch-dest", "document");
//            httpGet.addHeader("sec-fetch-mode", "navigate");
//            httpGet.addHeader("sec-fetch-site", "none");
//            httpGet.addHeader("sec-fetch-user", "?1");
//            httpGet.addHeader("upgrade-insecure-requests", "1");
//            httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response;
            response = httpClient.execute(httpGet);

            log.info("程序开始启动...");
//            long startTime = System.currentTimeMillis();
//            SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Main.class, SpringContext.class);
//            springApplicationBuilder.main(Main.class);
//            springApplicationBuilder.run(args);
//            // 添加程序关闭钩子
//            Runtime.getRuntime().addShutdownHook(new ShutdownHook());
//            log.info("恭喜 程序启动成功! 耗时:{}ms", System.currentTimeMillis() - startTime);
//
//            SpringContext.getApplicationContext().getBean(SignInService.class).signIn();

        } catch (Throwable e) {
            log.error("程序启动失败o(╥﹏╥)o", e);
            Runtime.getRuntime().exit(1);
        }
    }

}
