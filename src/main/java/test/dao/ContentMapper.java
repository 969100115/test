package test.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import test.bean.Order;
import test.bean.Project;
import test.common.BaseMapper;
import test.bean.Content;

import java.util.List;


@Repository
public interface ContentMapper extends BaseMapper<Content> {
    List<Content> listContentByType(@Param("type")String type);
    List<Content> listContentByProjectId(@Param("projectId") Integer userId);
}