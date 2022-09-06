package per.wsk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import per.wsk.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private PaymentService paymentService;


    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

    @GetMapping(value = "/consumer/payment/nacos/02/{id}")
    public String paymentInfo02(@PathVariable("id") Integer id) {
        return paymentService.getPayment02(id);
    }

}
