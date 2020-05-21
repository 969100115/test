package test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import test.bean.ProjectParam;
import test.common.BaseMapper;

import java.util.List;

@Repository
public interface ProjectParamMapper extends BaseMapper<ProjectParam> {
    List<ProjectParam> listProjectParamByOrderId(@Param("orderid")Integer orderId);
    String getStatusdownload(@Param("orderid")Integer orderid);
    String getWaydownload(@Param("orderid")Integer orderid);
    Integer insertway(@Param("orderid")Integer orderId,@Param("way")String way,@Param("status")String status);
    Integer insertvalue(@Param("orderid")Integer orderId,@Param("param")String param,@Param("value")String value);
    Integer deleteParams(@Param("orderid")Integer orderid);
    Integer deleteway(@Param("orderid")Integer orderid);
}
