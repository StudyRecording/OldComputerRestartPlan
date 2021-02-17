package computer.restart.plan.service;

import computer.restart.plan.mapper.MrUserMapper;
import computer.restart.plan.pojo.MrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MrUserServiceImpl
 * @Description
 * @Author hpc
 * @Date 2021/2/16 17:23
 **/
@Service
public class MrUserServiceImpl implements MrUserService{

    @Autowired
    private MrUserMapper mrUserMapper;

    /**
     * 根据email查询有效用户
     * @param email
     * @return
     */
    @Override
    public MrUser loadUserByEmail(String email) {
        return mrUserMapper.loadUserByEmail(email);
    }
}
