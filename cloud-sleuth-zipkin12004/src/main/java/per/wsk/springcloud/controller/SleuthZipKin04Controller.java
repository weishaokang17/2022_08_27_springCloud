package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SleuthZipKin04Controller {

    @Value("${spring.application.name}")
    private String serverName;

    @GetMapping("/service04/api01")
    public String sleuthZipKin04(@RequestParam(required = false) String requestServerName){
        String result = "服务 "+serverName+" 的接口 1 被 " + requestServerName +" 这个服务访问";
        System.out.println(result);
        return result;
    }

    @GetMapping("/service04/api02")
    public String sleuthZipKin04Api02(@RequestParam(required = false) String requestServerName){
        String result = "服务 "+serverName+" 的接口 2 被 " + requestServerName +" 这个服务访问";
        System.out.println(result);
        return result;
    }
}
