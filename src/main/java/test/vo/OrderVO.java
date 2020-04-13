package test.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import test.bean.Order;

@Data
public class OrderVO {
    int projectId;
    int price;
    int userId;
    String status;
    String createTime;
    String testPredictTime;
    String testCompleteTime;
    String orderCompleteTime;

    public static OrderVO createOrderVO(Order order) {
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order,orderVO);
        return orderVO;
    }

    public OrderVO() {
    }
}
