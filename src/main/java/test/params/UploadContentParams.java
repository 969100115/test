package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UploadContentParams {
    @ApiModelProperty("Id")
    Integer id;
    @ApiModelProperty("名称")
    String name;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("图片")
    String picture;
    @ApiModelProperty("场地")
    String place;
    @ApiModelProperty("类型")
    String type;


}
