package test.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(value = "订单管理")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "新建订单", httpMethod = "POST")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean addContent(@RequestBody OrderParams params) {
        Order order = new Order();
        BeanUtils.copyProperties(params, order);
        orderService.insertOrder(order);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(params, orderVO);
        return new ResultBean(orderVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查询用户所有订单，按状态分类", httpMethod = "POST")
    @RequestMapping(value = "listByUserId", method = RequestMethod.POST)
    public ResultBean listOrderByUserId(@RequestBody JSONObject params) {
        MyOrderListVO myOrderListVO = orderService.listOrderByUserId(params.getInteger("userId"));
        return new ResultBean(myOrderListVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查看所有订单", httpMethod = "POST")
    @RequestMapping(value = "listAll", method = RequestMethod.POST)
    public ResultBean listAllOrder(@RequestBody JSONObject params) {
        List<Order> orderList = orderService.listOrder();
        return new ResultBean(orderList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "订单详情", httpMethod = "POST")
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public ResultBean contentInfo(@RequestBody JSONObject params) {
        Order order = orderService.selectOrderById(params.getInteger("id"));
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        return new ResultBean(orderVO, ResultEnum.SUCCESS);
    }

}
