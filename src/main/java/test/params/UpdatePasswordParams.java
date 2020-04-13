package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdatePasswordParams {
    @ApiModelProperty("用户新密码")
    String password;
    @ApiModelProperty("用户Id")
    int id;
}
