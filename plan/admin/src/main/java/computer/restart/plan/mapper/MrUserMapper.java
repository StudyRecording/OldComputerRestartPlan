package computer.restart.plan.mapper;

import computer.restart.plan.pojo.MrUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName MrUserMapper
 * @Description
 * @Author hpc
 * @Date 2021/2/16 17:20
 **/
@FeignClient("provider")
public interface MrUserMapper {

    /**
     * 根据email查询用户
     * @param email
     * @return
     */
    @GetMapping("/user/loadUserByEmail/{email}")
    public MrUser loadUserByEmail(@PathVariable("email") String email);
}
