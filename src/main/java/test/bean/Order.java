package test.bean;

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
    int projectId;
    int userId;
    int price;
    String status;
    String createTime;
    String testPredictTime;
    String testComleteTime;
    String orderCompleteTime;
}
