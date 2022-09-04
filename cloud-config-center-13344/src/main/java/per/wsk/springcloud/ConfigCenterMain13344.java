package per.wsk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer //表明这是个 spring cloud config的模块
//@EnableEurekaClient
public class ConfigCenterMain13344 {


    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain13344.class,args);
    }

}
