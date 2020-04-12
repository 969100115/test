package test.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import test.common.BaseMapper;
import test.bean.Project;

import java.util.List;


@Repository
public interface ProjectMapper extends BaseMapper<Project> {
    List<Project> listProjectByType(@Param("type")String type);
    List<Project> searchByName(@Param("name")String name);
}