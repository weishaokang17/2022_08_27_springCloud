package per.wsk.springcloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import per.wsk.springcloud.entity.CommonResult;

public class BlockHandlerUtil {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }



}
