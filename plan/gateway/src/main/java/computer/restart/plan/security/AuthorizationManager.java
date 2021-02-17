package computer.restart.plan.security;

import cn.hutool.core.util.StrUtil;
import computer.restart.plan.config.WhiteListConfig;
import computer.restart.plan.constant.AuthConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import reactor.core.publisher.Mono;

/**
 * @ClassName AuthorizationManager
 * @Description 鉴权管理器
 * @Author hpc
 * @Date 2021/2/17 19:03
 **/
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {



    @Autowired
    private WhiteListConfig whiteListConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {

        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String path = request.getURI().getPath();
        AntPathMatcher pathMatcher = new AntPathMatcher();

        // 对应跨域的预检查直接放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // token为null拒绝访问
        String token = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        if (StrUtil.isBlank(token)) {
            System.out.println("------------------token问题");
            return Mono.just(new AuthorizationDecision(false));
        }
        System.out.println("--------------------------其它问题");

        return Mono.just(new AuthorizationDecision(true));
//        return mono
//                .filter(Authentication::isAuthenticated)
//                .flatMapIterable(Authentication::getAuthorities)
//                .map(GrantedAuthority::getAuthority)
//                .any(roleId -> {
//                    // 5. roleId是请求用户的角色(格式:ROLE_{roleId})，authorities是请求资源所需要角色的集合
////                    log.info("访问路径：{}", path);
////                    log.info("用户角色roleId：{}", roleId);
////                    log.info("资源需要权限authorities：{}", authorities);
////                    return authorities.contains(roleId);
//                    return true;
//                })
//                .map(AuthorizationDecision::new)
//                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}
