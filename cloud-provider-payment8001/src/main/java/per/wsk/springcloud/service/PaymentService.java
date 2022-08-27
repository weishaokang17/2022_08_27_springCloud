package per.wsk.springcloud.service;


import per.wsk.springcloud.entity.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
