package computer.restart.plan.service;

import computer.restart.plan.domain.User;
import computer.restart.plan.feign.MrUserMapper;
import computer.restart.plan.pojo.MrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description
 * @Author hpc
 * @Date 2021/2/16 19:16
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MrUserMapper mrUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("---------------------认证用户：" + s + "-------------------------");

        // 查询用户
        MrUser mrUser = mrUserMapper.loadUserByEmail(s);

        System.out.println("用户为：" + mrUser);
        return new User(mrUser);
    }
}
