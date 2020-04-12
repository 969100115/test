package test.bean;

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
    String name;
    String phone;
    String password;
    String nikename;
    String gender;
    String portrait;
    boolean deleted;
    String permission;
    String mail;

}
