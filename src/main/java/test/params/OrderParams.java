package test.params;

import lombok.Data;

@Data
public class OrderParams extends BaseParams {
    int projectId;
    int price;
    int userId;
    String status;
    String createTime;
    String testPredictTime;
    String testCompleteTime;
    String orderCompleteTime;

}
