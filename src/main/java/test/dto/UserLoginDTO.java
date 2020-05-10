package test.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginDTO extends BaseDTO {
    String password;
    String phone;
}
