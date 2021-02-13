package computer.restart.plan.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName MrUser
 * @Description 用户
 * @Author hpc
 * @Date 2021/2/12 21:17
 **/
@Data
@ApiModel("用户实体")
public class MrUser implements Serializable {
    private static final long serialVersionUID = -6982743467211252474L;

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户登录密码")
    private String password;

    @ApiModelProperty(value = "用户状态, true启用， false停用", allowableValues = "true, false")
    private Boolean enable;

    @Email
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户其它密码")
    private String privacyPsd;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;
}
