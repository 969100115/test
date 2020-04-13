package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wenbo
 * @date 2020/3/30 11:41
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "user")
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
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
