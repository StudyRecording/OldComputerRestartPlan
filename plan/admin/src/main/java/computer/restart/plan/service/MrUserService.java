package computer.restart.plan.service;

import computer.restart.plan.pojo.MrUser;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@ClassName MrUserService
 *@Description
 *@Author hpc
 *@Date 2021/2/16 17:22
 **/
public interface MrUserService {

    /**
     * 根据邮箱查询有效用户
     * @param email
     * @return
     */
    MrUser loadUserByEmail(@PathVariable("email") String email);
}
