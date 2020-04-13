package test.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Wenbo
 * @date 2020/3/30 14:25
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
public class TestMethod {
    @ApiModelProperty("测试方法名")
    String name;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("验收标准")
    String standard;
    @ApiModelProperty("难度系数")
    int difficulty;
}
