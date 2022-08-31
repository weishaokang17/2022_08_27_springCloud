package per.wsk.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import per.wsk.springcloud.entity.CommonResult;
import per.wsk.springcloud.entity.Payment;
import per.wsk.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***** 插入数据成功 : "+result);
        if (result >0) {
            return new CommonResult(200,"插入数据成功, 服务端口号: " + serverPort);
        } else {
            return new CommonResult(444,"插入数据失败, 服务端口号: " + serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200,"查询成功, 服务端口号: " + serverPort,payment);
        } else {
            return new CommonResult(444,"没有对应记录, 查询id : " + id,payment);
        }
    }


    /**
     * 只返回当前服务实例的端口号
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    /**
     * 测试微服务之间调用的超时问题
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
