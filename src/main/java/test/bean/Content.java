package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wenbo
 * @date 2020/3/30 14:21
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "content")
public class Content {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @ApiModelProperty("名称")
    @Column(name = "name")
    String name;

    @ApiModelProperty("描述")
    @Column(name = "description")
    String description;

    @ApiModelProperty("图片,地址以||进行分割")
    @Column(name = "picture")
    String picture;

    @ApiModelProperty("场地")
    @Column(name = "place")
    String place;

    @ApiModelProperty("类型")
    @Column(name = "type")
    String type;
}
