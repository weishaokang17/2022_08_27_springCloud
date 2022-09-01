package per.wsk.springcloud.service.impl;

import org.springframework.stereotype.Service;
import per.wsk.springcloud.service.PaymentService;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //耗时 3 秒
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): ";
    }
}
