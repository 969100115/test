package test.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wenbo
 * @date 2020/3/30 14:25
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class TestMethod {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "name")
    @ApiModelProperty("测试方法名")
    String name;

    @Column(name = "description")
    @ApiModelProperty("描述")
    String description;

    @Column(name = "standard")
    @ApiModelProperty("验收标准")
    String standard;

    @Column(name = "difficulty")
    @ApiModelProperty("难度系数")
    int difficulty;
}
