package test.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.bean.Content;
import test.bean.Order;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.params.ContentParams;
import test.params.OrderParams;
import test.service.ContentService;
import test.service.OrderService;
import test.vo.ContentVO;
import test.vo.MyOrderListVO;
import test.vo.OrderVO;

import java.util.List;

@RestController
@RequestMapping("order/")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("add")
    public ResultBean addContent (@RequestBody OrderParams params){
        Order order = new Order();
        BeanUtils.copyProperties(params,order);
        orderService.insertOrder(order);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(params,orderVO);
        return new ResultBean(orderVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("listByUserId")
    public ResultBean listOrderByUserId (@RequestBody OrderParams params){
        MyOrderListVO myOrderListVO = orderService.listOrderByUserId(params.getUserId());
        return new ResultBean(myOrderListVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("listAll")
    public ResultBean listAllOrder (@RequestBody OrderParams params){
        List<Order> orderList = orderService.listOrder();
        return new ResultBean(orderList, ResultEnum.SUCCESS);
    }

    @RequestMapping("info")
    public ResultBean contentInfo(@RequestBody JSONObject params){
        Order order = orderService.selectOrderById(params.getInteger("id"));
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order,orderVO);
        return new ResultBean(orderVO, ResultEnum.SUCCESS);
    }

}
