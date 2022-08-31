package per.wsk.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig
{
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // 共 NONE,BASIC,HEADERS,FULL 这四个取值
    }

    /**
     Spring Cloud 中 Feign的日志记录级别

     NONE：没有日志记录
     BASIC：记录请求方法、URL以及响应状态代码和执行时间
     HEADERS：记录基本信息以及请求和响应头信息
     FULL：记录基本信息以及请求和响应头信息、请求和响应体信息
     */
}
