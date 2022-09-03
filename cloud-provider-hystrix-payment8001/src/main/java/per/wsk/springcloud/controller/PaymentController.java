package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result: " + result);
        return result;
    }


    /*
    上面那个接口，处理的非常快
    下面这个接口，因为里面的线程睡了3秒，处理的比较慢
    此时用jmeter，用100个线程，每一个线程同时向该接口发200个请求。此时该服务就会非常卡顿。
    因为这两个接口在同一个服务中，此时，因为这个接口访问的量太多，如果此时哪怕上面的接口，只有1个线程的 1次请求，但因为和当前
    这个访问量非常大的接口在同一个服务中，这个接口导致服务非常卡顿，所以上面那个访问量非常小的接口，也会变得非常卡顿。
    此时，就要对当前这个接口做 降级、熔断、限流的处理。

    或者用jmeter，用100个线程，每一个线程同时向当前接口发200个请求。此时该服务就会非常卡顿。
    此时cloud-provider-hystrix-payment8001 这个服务的接口A，访问上面那个接口，也会变慢，进而导致
    cloud-provider-hystrix-payment8001服务的A接口也会变慢
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result: " + result);
        return result;
    }



    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
