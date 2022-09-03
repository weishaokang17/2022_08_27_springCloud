package per.wsk.springcloud.service;

public interface PaymentService {


    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    /**
     * 耗时方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id);

    /**
     * 测试 熔断功能
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
