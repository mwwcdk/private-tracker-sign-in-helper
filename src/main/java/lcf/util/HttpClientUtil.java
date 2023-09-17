package lcf.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * HTTP客户端工具
 */
public class HttpClientUtil {

    private CloseableHttpClient httpClient = HttpClients.createDefault();

}
