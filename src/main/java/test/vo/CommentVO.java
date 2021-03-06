package test.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentVO {
    @ApiModelProperty("用户Id")
    Integer userId;
    @ApiModelProperty("评论内容")
    String description;
    @ApiModelProperty("评论图片,地址以||进行分割")
    String picture;
    @ApiModelProperty("评论主题Id")
    Integer projectId;
    @ApiModelProperty("评论点赞次数")
    Integer numbers;
    @ApiModelProperty("评论type")
    String type;
    @ApiModelProperty("用户name")
    String name;
}
