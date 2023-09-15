package lcf;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import lcf.application.ShutdownHook;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 程序入口类
 */
@Slf4j
public class Main {

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        log.info("程序开始启动...");
        long startTime = System.currentTimeMillis();
        // 这里使用了Netty提供的事件循环组, 用于做定时调度
        EventLoopGroup eventLoopGroup = new DefaultEventLoopGroup();
        eventLoopGroup.scheduleAtFixedRate(() -> {
            log.info("定时调度, 当前秒:" + System.currentTimeMillis() / 1000);
            System.out.println("定时调度, 当前秒:" + System.currentTimeMillis() / 1000);
        }, 5000, 2000, TimeUnit.MILLISECONDS);
        // 添加程序关闭钩子
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(eventLoopGroup));
        log.info("恭喜 程序启动成功! 耗时:{}ms", System.currentTimeMillis() - startTime);
    }

}
