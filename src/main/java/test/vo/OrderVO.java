package test.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import test.bean.Order;

import java.util.Date;

@Data
public class OrderVO {
    int projectId;
    int price;
    int userId;
    String status;
    Date createTime;
    Date testPredictTime;
    Date testCompleteTime;
    Date orderCompleteTime;


    public static OrderVO createOrderVO(Order order) {
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order,orderVO);
        return orderVO;
    }

    public OrderVO() {
    }
}
