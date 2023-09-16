package lcf.executor.configuration;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 执行器 配置
 */
@Configuration
public class ExecutorConfiguration {

    /**
     * 事件执行器
     * @return
     */
    @Bean
    EventLoopGroup eventLoopGroup() {
        return new DefaultEventLoop();
    }

}
