package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.service.SleuthZipKin03Service;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SleuthZipKin03Controller {

    @Value("${spring.application.name}")
    private String serverName;

    @Resource
    private SleuthZipKin03Service service;

    @GetMapping("/service03/api01")
    public String sleuthZipKin03(@RequestParam(required = false) String requestServerName){
        service.sleuthZipKin04(serverName);

        String result = "服务 "+serverName+" 的接口 1 被 " + requestServerName +" 这个服务访问";
        System.out.println(result);
        return result;
    }

}
