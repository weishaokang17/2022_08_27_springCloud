package per.wsk.springcloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import per.wsk.springcloud.entity.CommonResult;

public class FallbackUtil {

    public static CommonResult failBack(Throwable e) {
        return new CommonResult(4444,"系统出现异常  "+e.getMessage());
    }
}
