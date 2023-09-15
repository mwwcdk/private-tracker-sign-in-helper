package lcf.application;

import io.netty.channel.EventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * 关服钩子
 */
@Slf4j
public class ShutdownHook extends Thread {

    /** 事件循环组(线程池) */
    private EventLoopGroup eventLoopGroup;

    public ShutdownHook(EventLoopGroup eventLoopGroup) {
        this.eventLoopGroup = eventLoopGroup;
    }

    @Override
    public void run() {
        log.info("程序关闭钩子开始执行...");
        eventLoopGroup.shutdownGracefully();
        log.info("程序关闭钩子执行完毕。");
    }

}
