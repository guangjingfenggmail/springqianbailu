package com.open.springqianbailu.rest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomErrorHandler());
        return restTemplate;
    }


//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(clientHttpRequestFactory());
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
//        return restTemplate;
//    }
//    @Bean
//    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
//        try {
//            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
//                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//                    return true;
//                }
//            }).build();
//            httpClientBuilder.setSSLContext(sslContext);
//            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
//            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
//            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                    .register("https", sslConnectionSocketFactory).build();// 注册http和https请求
//            // 开始设置连接池
//            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//            poolingHttpClientConnectionManager.setMaxTotal(500); // 最大连接数500
//            poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100); // 同路由并发数100
//            httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
//            httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true)); // 重试次数
//            HttpClient httpClient = httpClientBuilder.build();
//            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient); // httpClient连接配置
//            clientHttpRequestFactory.setConnectTimeout(20000);              // 连接超时
//            clientHttpRequestFactory.setReadTimeout(30000);                 // 数据读取超时时间
//            clientHttpRequestFactory.setConnectionRequestTimeout(20000);    // 连接不够用的等待时间
//            return clientHttpRequestFactory;
//        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
//            log.error("初始化HTTP连接池出错", e);
//        }
//        return null;
//    }
}
