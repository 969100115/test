package test.dto;

import lombok.Data;
import test.params.BaseParams;

@Data
public class UpdatePasswordDTO extends BaseDTO {
    String password;
    int id;
}
