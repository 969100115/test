package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * @author Wenbo
 * @date 2020/3/30 13:48
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @ApiModelProperty("主题名称")
    String name;
    @ApiModelProperty("展示图片，地址按||分割")
    @Column(name = "showPicture")
    String showPicture;
    @ApiModelProperty("是否删除")
    @Column(name = "deleted")
    boolean deleted = false;
    @ApiModelProperty("价格")
    int price;
    @ApiModelProperty("难度系数")
    int duration;
    @ApiModelProperty("分类")
    String type;
    @ApiModelProperty("描述")
    @Column(name = "description")
    String description;
    @ApiModelProperty("描述图片，地址按||分割")
    @Column(name = "detailPicture")
    String detailPicture;

}
