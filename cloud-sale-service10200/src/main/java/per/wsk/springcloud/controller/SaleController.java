package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SaleController {

    @GetMapping("/sale/getSales")
    public String getSales(){
        return "获取所有订单";
    }

    @GetMapping("/sale/addSale")
    public String addSale(){
        return "添加订单";
    }

}
