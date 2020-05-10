package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginParams {
    @ApiModelProperty("用户新密码")
    String password;
    @ApiModelProperty("用户手机号")
    String phone;
}
