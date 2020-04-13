package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Wenbo
 * @date 2020/3/30 14:34
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
public class Order {

    int id;
    @ApiModelProperty("主题Id")
    int projectId;
    @ApiModelProperty("用户Id")
    int userId;
    @ApiModelProperty("价格")
    int price;
    @ApiModelProperty("状态")
    String status;
    @ApiModelProperty("订单创建时间")
    String createTime;
    @ApiModelProperty("测试时间")
    String testPredictTime;
    @ApiModelProperty("测试完成时间")
    String testCompleteTime;
    @ApiModelProperty("订单完成时间")
    String orderCompleteTime;
}
