package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import test.dto.BaseDTO;

@Data
public class CommentSelectParams extends BaseDTO {
    @ApiModelProperty("类型")
    String type;
    @ApiModelProperty("主题Id")
    int projectId;
}
