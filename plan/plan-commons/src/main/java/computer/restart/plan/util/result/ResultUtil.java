package computer.restart.plan.util.result;

import computer.restart.plan.result.Result;

/**
 * @ClassName ResultUtil
 * @Description 返回工具类
 * @Author hpc
 * @Date 2021/2/14 18:52
 **/
public class ResultUtil {

    /**
     * 请求成功
     * @param <T>
     * @return
     */
    public static<T> Result<T> success() {
        return new Result<>(HttpStatus.SUCCESS, "操作成功!");
    }

    /**
     * 请求成功
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data) {
        return new Result<>(HttpStatus.SUCCESS, "操作成功!", data);
    }

    /**
     * 操作失败
     * @param <T>
     * @return
     */
    public static<T> Result<T> error() {
        return new Result<>(HttpStatus.SYSTEM_ERR, "操作失败!");
    }

    /**
     * 操作失败
     * @param msg 返回错误消息
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static<T> Result<T> error(String msg, T data) {
        return new Result<>(HttpStatus.SYSTEM_ERR, msg, data);
    }

    /**
     * 操作失败
     * @param msg
     * @param <T>
     * @return
     */
    public static<T> Result<T> error(String msg) {
        return new Result<>(HttpStatus.SYSTEM_ERR, msg, null);
    }

    /**
     * 操作失败
     * @param data 返回错误数据
     * @param <T>
     * @return
     */
    public static<T> Result<T> error(T data) {
        return new Result<>(HttpStatus.SYSTEM_ERR, "操作失败!", data);
    }

    /**
     * 认证失败
     * @param <T>
     * @return
     */
    public static<T> Result<T> authenticationErr() {
        return new Result<>(HttpStatus.AUTHENTICATION_FAIL, "认证失败！", null);
    }

    /**
     * 认证失败
     * @param <T>
     * @return
     */
    public static<T> Result<T> authenticationErr(String msg) {
        return new Result<>(HttpStatus.AUTHENTICATION_FAIL, msg, null);
    }

    /**
     * 未授权错误
     * @param <T>
     * @return
     */
    public static<T> Result<T> forbiddenErr() {
        return new Result<>(HttpStatus.FORBIDDEN, "用户没有权限，无法访问", null);
    }

    /**
     * 未授权错误
     * @param <T>
     * @return
     */
    public static<T> Result<T> forbiddenErr(String msg) {
        return new Result<>(HttpStatus.FORBIDDEN, msg, null);
    }
}
