package computer.restart.plan.controller;

import computer.restart.plan.result.Result;
import computer.restart.plan.util.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author hpc
 * @Date 2021/2/16 16:44
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/gateWay")
    public Result testGateWay() {
        return ResultUtil.success("测试网关！");
    }
}
