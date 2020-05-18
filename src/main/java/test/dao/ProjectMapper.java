package test.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import test.common.BaseMapper;
import test.bean.Project;
import test.vo.ProjectContentIdVO;
import test.vo.ProjectVO;

import java.util.List;


@Repository
public interface ProjectMapper extends BaseMapper<Project> {
    List<Project> listProjectByType(@Param("type")String type);
    List<ProjectContentIdVO> listProjectAll();
    List<Project> searchByName(@Param("name")String name);
    List<String> listProjectType();
    int insertProjectContent(@Param("contentId")Integer contentId,@Param("projectId")Integer projectId);
    int deleteRelationByProjectId(@Param("projectId")Integer projectId);
}