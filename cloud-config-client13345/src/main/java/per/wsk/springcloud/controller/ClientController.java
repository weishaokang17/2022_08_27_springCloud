package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClientController {


//    @Value("${spring.database.url}")
    @Value("${user.name}")
    private String databaseUrl;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return databaseUrl;
    }

}
