package lcf.http.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HTTP 配置
 */
@Configuration
public class HttpConfiguration {

    /**
     * HTTP客户端
     * @return
     */
    @Bean
    CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }

}
