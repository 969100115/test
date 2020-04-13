package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author Wenbo
 * @date 2020/3/30 14:21
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "content")
public class Content {
    @ApiModelProperty("名称")
    String name;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("图片,地址以||进行分割")
    String picture;
    @ApiModelProperty("场地")
    String place;
    @ApiModelProperty("类型")
    String type;
}
