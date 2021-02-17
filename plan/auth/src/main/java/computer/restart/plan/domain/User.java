package computer.restart.plan.domain;

import computer.restart.plan.constant.AuthConstants;
import computer.restart.plan.pojo.MrUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName User
 * @Description 登录用户信息
 * @Author hpc
 * @Date 2021/2/16 20:27
 **/
@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Boolean enable;

    private Collection<SimpleGrantedAuthority> authorities;

    public User(MrUser user) {
        this.setId(user.getId());
        this.setUsername(user.getEmail());
        this.setPassword(AuthConstants.BCRYPT + user.getPassword());
        this.setNickname(user.getUsername());
        this.setEnable(user.getEnable());
        this.authorities = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
