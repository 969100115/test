package test.params;

import lombok.Data;

@Data
public class AddUserParams extends BaseParams {
    String name;
    String phone;
    String password;
    String nikename;
    String gender;
    String portrait;
    String deleted;
    String permission;
    String mail;
}
