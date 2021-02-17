package computer.restart.plan.controller.user;

import computer.restart.plan.result.Result;
import computer.restart.plan.service.MrUserService;
import computer.restart.plan.util.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MrUserController
 * @Description 用户查询
 * @Author hpc
 * @Date 2021/2/16 17:24
 **/
@RestController
@RequestMapping("/user")
public class MrUserController {

    @Autowired
    private MrUserService mrUserService;

    /**
     * 根据email查询用户
     * @param email
     * @return
     */
    @GetMapping("/loadUserByEmail/{email}")
    public Result loadUserByEmail(@PathVariable("email") String email) {
        return ResultUtil.success(mrUserService.loadUserByEmail(email));
    }
}
