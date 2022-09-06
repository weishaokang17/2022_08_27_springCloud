package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.service.SleuthZipKin0202Service;
import per.wsk.springcloud.service.SleuthZipKin02Service;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SleuthZipKin02Controller {

    @Value("${spring.application.name}")
    private String serverName;

    @Resource
    private SleuthZipKin02Service service03;

    @Resource
    private SleuthZipKin0202Service service04;

    @GetMapping("/service02/api01")
    public String sleuthZipKin03(@PathVariable("requestServerName") String requestServerName){
        //当前是服务2,调用服务3
        service03.sleuthZipKin03(serverName);
        //当前是服务2,调用服务4
        service04.sleuthZipKin04Api02(serverName);

        return "服务 "+serverName+" 的接口 1 被 " + requestServerName +" 这个服务访问";
    }
}
