package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RefreshScope
public class ClientController {


    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${henan.anyang.haxian}")
    private String xiangzhen;

    @Value("${collage.specialty}")
    private String zhuanye;

    @Value("${user.name}")
    private String userName;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public Map<String,Object> getConfigInfo() {
        Map map = new HashMap<>();
        map.put("databaseUrl",databaseUrl);
        map.put("xiangzhen",xiangzhen);
        map.put("zhuanye",zhuanye);
        map.put("userName",userName);
        map.put("serverPort",serverPort);
        return map;
    }

}
