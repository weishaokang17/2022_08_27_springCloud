package per.wsk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.Map;

@RestController
@RefreshScope //支持Nacos的动态刷新功能。
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }


    @Value("${db.driver.className}")
    private String dbDriver;
    @Value("${db.url}")
    private String dbUrl;
    @Value("${redis.name}")
    private String redisName;
    @Value("${rocketmq.name}")
    private String rocketMqName;

    @GetMapping("/getMap")
    public Map<String,String> getMap(){
        Map<String,String> resultMap = new Hashtable<>();

        resultMap.put("dbDriver",dbDriver);
        resultMap.put("redisName",redisName);
        resultMap.put("dbUrl",dbUrl);
        resultMap.put("rocketMqName",rocketMqName);

        return resultMap;
    }
}
