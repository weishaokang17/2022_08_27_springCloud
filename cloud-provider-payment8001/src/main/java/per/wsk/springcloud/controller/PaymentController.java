package per.wsk.springcloud.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import per.wsk.springcloud.entity.CommonResult;
import per.wsk.springcloud.entity.Payment;
import per.wsk.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * 服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 发现每个服务，以及每个服务下的集群的实例
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        //获取每个服务的名称
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }
        //根据后面这个服务名称，查询这个服务的集群中每一个实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            /*
            CLOUD-PAYMENT-SERVICE	192.168.3.66	8002	http://192.168.3.66:8002
            CLOUD-PAYMENT-SERVICE	192.168.3.66	8001	http://192.168.3.66:8001
             */
        }
        return this.discoveryClient;
    }



    /**
     * 只返回当前服务实例的端口号
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
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
