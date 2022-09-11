package per.wsk.springcloud.service.impl;

import org.springframework.stereotype.Component;
import per.wsk.springcloud.entity.CommonResult;
import per.wsk.springcloud.entity.Payment;
import per.wsk.springcloud.service.PaymentService;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",
                new Payment(id,"errorSerial"));
    }
}
