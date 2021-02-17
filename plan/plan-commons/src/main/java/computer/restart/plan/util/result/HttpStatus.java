package computer.restart.plan.util.result;

/**
 * @ClassName HttpStatus
 * @Description 返回状态码
 * @Author hpc
 * @Date 2021/2/14 18:53
 **/
public class HttpStatus {

    /**
     * 请求成功
     */
    public static final Integer SUCCESS = 200;

    /**
     * 系统错误
     */
    public static final Integer SYSTEM_ERR = 500;

    /**
     * 认证失败
     */
    public static final Integer AUTHENTICATION_FAIL = 401;

    /**
     * 未授权
     */
    public static final Integer FORBIDDEN = 403;
}
