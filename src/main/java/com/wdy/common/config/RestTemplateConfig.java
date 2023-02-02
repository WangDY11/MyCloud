package com.wdy.common.config;

import com.wdy.common.resttemplet.RestTemplateExceptionHandle;
import com.wdy.common.resttemplet.RestTemplateInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc RestTemplate配置
 * @date 2019/5/24
 * @author wjy
 */
@Configuration
public class RestTemplateConfig {

    @Autowired
    private RestTemplateInterceptor interceptor;

    @Autowired
    private RestTemplateExceptionHandle exceptionHandle;

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(interceptor);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient());
        return factory;
    }

    @Bean
    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registry);
        // 单个服务并行处理的最大请求数量
        manager.setDefaultMaxPerRoute(10);
        // 每次处理的最大请求数量
        manager.setMaxTotal(20);
        RequestConfig config = RequestConfig.custom()
                // 获取连接池中连接的超时时间
                .setConnectionRequestTimeout(10000)
                // 客户端连接服务端的超时时间
                .setConnectTimeout(10000)
                // 服务端响应的超时时间
                .setSocketTimeout(10000).build();
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(manager).setDefaultRequestConfig(config).build();
        return httpClient;
    }

}
