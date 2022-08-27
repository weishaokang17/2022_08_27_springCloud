package per.wsk.springcloud.service.impl;

import org.springframework.stereotype.Service;
import per.wsk.springcloud.dao.PaymentDao;
import per.wsk.springcloud.entity.Payment;
import per.wsk.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
