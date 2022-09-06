package per.wsk.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-sleuth-zipkin12004")
public interface SleuthZipKin03Service {

    @GetMapping("/service04/api01")
    public String sleuthZipKin04(@PathVariable("requestServerName") String requestServerName);

}
