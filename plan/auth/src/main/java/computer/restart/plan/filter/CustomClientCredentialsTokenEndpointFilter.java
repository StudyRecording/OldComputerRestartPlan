package computer.restart.plan.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @ClassName CustomClientCredentialsTokenEndpointFilter
 * @Description 重写客户端自定义异常处理
 * @Author hpc
 * @Date 2021/2/16 20:53
 **/
public class CustomClientCredentialsTokenEndpointFilter extends ClientCredentialsTokenEndpointFilter {

    private AuthorizationServerSecurityConfigurer configurer;
    private AuthenticationEntryPoint authenticationEntryPoint;

    public CustomClientCredentialsTokenEndpointFilter(AuthorizationServerSecurityConfigurer configurer) {
        this.configurer = configurer;
    }

    @Override
    public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
        super.setAuthenticationEntryPoint(null);
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected AuthenticationManager getAuthenticationManager() {
        return configurer.and().getSharedObject(AuthenticationManager.class);
    }

    @Override
    public void afterPropertiesSet() {
        setAuthenticationFailureHandler((request, response, e) -> authenticationEntryPoint.commence(request, response, e));
        setAuthenticationSuccessHandler((request, response, authentication) -> {});
    }
}