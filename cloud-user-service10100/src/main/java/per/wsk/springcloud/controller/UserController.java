package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/user/register")
    public String register(){
        return "注册接口";
    }


    @GetMapping("/user/login")
    public String login(){
        return "登录接口";
    }

    @GetMapping("/user/auth")
    public String auth(){
        return "认证接口";
    }

    @GetMapping("/user/modifyMobile")
    public String modifyMobile(){
        return "修改手机接口";
    }


}
