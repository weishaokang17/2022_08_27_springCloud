package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.service.SleuthZipKin01Service;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SleuthController01 {

    @Value("${spring.application.name}")
    private String serverName;

    @Resource
    private SleuthZipKin01Service service;

    @GetMapping("/service01/api01")
    public String sleuthZipKin02(){
        service.sleuthZipKin03(serverName);

        String result = "服务 "+serverName+" 的接口 1 被 客户端访问";
        System.out.println(result);

        return result;
    }
}
