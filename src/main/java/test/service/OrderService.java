package test.service;

import test.bean.*;
import test.vo.MyOrderListVO;

import java.util.List;

public interface OrderService {
    int insertOrder(Order bean);

    int updateOrder(Order bean);

    int deleteOrderById(int id);

    public Order selectOrderById(int id);

    MyOrderListVO listOrderByUserId(int userId);

    List<Order> listOrder();


}