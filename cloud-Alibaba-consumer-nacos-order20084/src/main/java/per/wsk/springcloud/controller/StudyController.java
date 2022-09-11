package per.wsk.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.springcloud.config.BlockHandlerUtil;
import per.wsk.springcloud.config.FallbackUtil;
import per.wsk.springcloud.entity.CommonResult;
import per.wsk.springcloud.entity.Payment;

import javax.validation.constraints.Null;

@RestController
@Slf4j
public class StudyController {


    @GetMapping("/getResult")
    @SentinelResource(value = "abc")
    public String getResult(){
        return "result";
    }

    @GetMapping("/getSeagate")
    @SentinelResource(value = "hi",blockHandler = "handleException")
    public String getSeagate(){
        return "seagate";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "efg",
            blockHandlerClass = BlockHandlerUtil.class,
            blockHandler = "handlerException",
            fallbackClass = FallbackUtil.class,
            fallback = "failBack",
            exceptionsToIgnore={NullPointerException.class,ArithmeticException.class})
    public CommonResult byResource() {
        int i = 10/0;
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }


    public CommonResult failRequest(Throwable e){
        return new CommonResult(555,"代码异常  "+e.getMessage());
    }

}
