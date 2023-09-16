package lcf.application;

import io.netty.channel.EventLoopGroup;
import lcf.SpringContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 关服钩子
 */
@Slf4j
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        log.info("程序关闭钩子开始执行...");
        SpringContext.getEventLoopGroup().shutdownGracefully();
        log.info("程序关闭钩子执行完毕。");
    }

}
