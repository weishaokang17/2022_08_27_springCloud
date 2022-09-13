package per.wsk.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.domain.CommonResult;
import per.wsk.springcloud.domain.Order;
import per.wsk.springcloud.service.OrderService;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
//        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
