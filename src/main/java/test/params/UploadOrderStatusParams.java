package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UploadOrderStatusParams {
    @ApiModelProperty("Id")
    int id;
    @ApiModelProperty("订单状态")
    String status;

}
