package com.sg.mycloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @ClassName RestConfig
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 13:41
 * @Since 1.0
 **/
@Configuration
public class RestConfig {
    @Bean
    @LoadBalanced // ribbon配置
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 要进行一个Http头信息配置
    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
        String auth = "admin:12345678"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }

//    @Bean
//    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
//        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略,默认是轮询
//    }
}
