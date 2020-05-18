package test.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UploadProjectParams {
    @ApiModelProperty("主题Id")
    Integer id;
    @ApiModelProperty("主题名称")
    String name;
    @ApiModelProperty("展示图片，地址按||分割")
    String showPicture;
    @ApiModelProperty("是否删除")
    boolean deleted = false;
    @ApiModelProperty("价格")
    int price;
    @ApiModelProperty("难度系数")
    int duration;
    @ApiModelProperty("分类")
    String type;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("描述图片，地址按||分割")
    String detailPicture;
    @ApiModelProperty("内容Id")
    List<Integer> contentIdList ;

}
