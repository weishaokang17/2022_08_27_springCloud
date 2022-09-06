package per.wsk.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloudAlibaba-payment-provider")
public interface PaymentService {

    @GetMapping(value = "/payment/nacos/02/{id}")
    public String getPayment02(@PathVariable("id") Integer id);
}
