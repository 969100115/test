package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "comment")
public class Comment {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @Column(name = "userId")
    @ApiModelProperty("用户Id")
    Integer userId;
    @Column(name = "description")
    @ApiModelProperty("评论内容")
    String description;
    @Column(name = "picture")
    @ApiModelProperty("评论图片,地址以||进行分割")
    String picture;
    @Column(name = "projectId")
    @ApiModelProperty("评论主题Id")
    Integer projectId;
    @Column(name = "numbers")
    @ApiModelProperty("评论点赞次数")
    Integer numbers;
    @Column(name = "type")
    @ApiModelProperty("评论type")
    String type;
}