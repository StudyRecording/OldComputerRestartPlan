package computer.restart.plan.controller;

import computer.restart.plan.result.Result;
import computer.restart.plan.util.result.ResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LogoutController
 * @Description 注销
 * @Author hpc
 * @Date 2021/2/16 21:44
 **/
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
public class LogoutController {

    @DeleteMapping("/logout")
    public Result logout() {
        return ResultUtil.success();
    }
}
