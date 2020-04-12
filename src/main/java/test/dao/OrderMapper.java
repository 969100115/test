package test.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import test.common.BaseMapper;
import test.bean.Order;

import java.util.List;


@Repository
public interface OrderMapper extends BaseMapper<Order> {
   List<Order> listOrderByUserId (@Param("userId") Integer userId);

}