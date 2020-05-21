package test.service;

import test.bean.Order;
import test.bean.ProjectParam;
import test.vo.MyOrderListVO;

import java.util.List;


public interface ProjectParamService {

    List<ProjectParam> listProjectParam(Integer orderId);


}