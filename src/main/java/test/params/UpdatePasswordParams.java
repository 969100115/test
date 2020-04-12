package test.params;

import lombok.Data;

@Data
public class UpdatePasswordParams {
    String password;
    int id;
}
