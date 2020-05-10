package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wenbo
 * @date 2020/3/30 11:41
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "name")
    @ApiModelProperty("用户姓名")
    String name;

    @Column(name = "phone")
    @ApiModelProperty("用户联系方式")
    String phone;

    @Column(name = "password")
    @ApiModelProperty("用户密码")
    String password;

    @Column(name = "nikename")
    @ApiModelProperty("用户昵称")
    String nikename;

    @Column(name = "gender")
    @ApiModelProperty("用户性别")
    String gender;

    @Column(name = "portrait")
    @ApiModelProperty("用户头像")
    String portrait;

    @Column(name = "deleted")
    @ApiModelProperty("是否删除")
    boolean deleted;

    @Column(name = "permission")
    @ApiModelProperty("用户权限")
    String permission;

    @Column(name = "mail")
    @ApiModelProperty("用户邮箱")
    String mail;

}
