package test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wenbo
 * @date 2020/3/30 14:34
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
public class Order {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @ApiModelProperty("主题Id")
    @Column(name = "projectId")
    int projectId;

    @ApiModelProperty("用户Id")
    @Column(name = "userId")
    int userId;

    @ApiModelProperty("价格")
    @Column(name = "price")
    int price;

    @ApiModelProperty("状态")
    @Column(name = "status")
    String status = "0";

    @ApiModelProperty("订单创建时间")
    @Column(name = "createTime")
    String createTime;

    @ApiModelProperty("测试时间")
    @Column(name = "testPredictTime")
    String testPredictTime;

    @ApiModelProperty("测试完成时间")
    @Column(name = "testCompleteTime")
    String testCompleteTime;

    @ApiModelProperty("订单完成时间")
    @Column(name = "orderCompleteTime")
    String orderCompleteTime;
}
