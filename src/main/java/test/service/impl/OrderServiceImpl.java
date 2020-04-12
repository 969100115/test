package test.service.impl;

import test.bean.*;
import test.service.*;
import test.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.vo.MyOrderListVO;
import test.vo.OrderVO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public int insertOrder(Order bean) {
        return orderMapper.insert(bean);
    }

    @Override
    public int updateOrder(Order bean) {
        return orderMapper.updateByPrimaryKey(bean);
    }

    @Override
    public int deleteOrderById(int id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Order selectOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public MyOrderListVO listOrderByUserId(int userId) {
        List<Order> orderList = orderMapper.listOrderByUserId(userId);
        MyOrderListVO myOrderListVO = new MyOrderListVO();
        for (Order order:orderList) {
            if("1".equals(order.getStatus())){
                myOrderListVO.getUnAccomplishList().add(OrderVO.createOrderVO(order));
            }else if("2".equals(order.getStatus())){
                myOrderListVO.getUnConfirmedList().add(OrderVO.createOrderVO(order));
            }else if("3".equals(order.getStatus())){
                myOrderListVO.getUnTestList().add(OrderVO.createOrderVO(order));
            }
        }
        return myOrderListVO;
    }

    @Override
    public List<Order> listOrder() {
        return orderMapper.selectAll();
    }


}