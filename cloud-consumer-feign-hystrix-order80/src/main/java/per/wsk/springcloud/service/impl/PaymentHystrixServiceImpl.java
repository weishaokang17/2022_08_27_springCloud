package per.wsk.springcloud.service.impl;

import org.springframework.stereotype.Component;
import per.wsk.springcloud.service.PaymentHystrixService;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {


    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }

}
