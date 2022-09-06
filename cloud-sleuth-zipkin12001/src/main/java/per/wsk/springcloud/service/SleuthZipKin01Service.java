package per.wsk.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-sleuth-zipkin12002")
public interface SleuthZipKin01Service {

    @GetMapping("/service02/api01")
    public String sleuthZipKin03(@PathVariable("requestServerName") String requestServerName);

}
