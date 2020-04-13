package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddUserParams extends BaseParams {
    @ApiModelProperty("用户姓名")
    String name;
    @ApiModelProperty("用户联系方式")
    String phone;
    @ApiModelProperty("用户密码")
    String password;
    @ApiModelProperty("用户昵称")
    String nikename;
    @ApiModelProperty("用户年龄")
    String gender;
    @ApiModelProperty("用户头像")
    String portrait;
    @ApiModelProperty("是否删除")
    boolean deleted;
    @ApiModelProperty("用户权限")
    String permission;
    @ApiModelProperty("用户邮箱")
    String mail;
}
