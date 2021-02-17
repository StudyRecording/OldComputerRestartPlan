package computer.restart.plan.result;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description 返回结果
 * @Author hpc
 * @Date 2021/2/14 18:48
 **/
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 8214321887026003093L;

    /**
     * 状态码
     **/
    private Integer code;

    /**
     * 返回数据
     **/
    private String msg;

    /**
     * 返回数据
     **/
     private T date;

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public Result() {
    }

    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

}
