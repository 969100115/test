package test.service;

import test.bean.*;
import test.dto.ProjectDTO;
import test.vo.ProjectContentIdVO;
import test.vo.ProjectVO;

import java.util.List;

public interface ProjectService {
    int insertProject(Project bean);

    int updateProject(Project bean);

    int deleteProjectById(int id);

    ProjectDTO selectProjectById(Integer id);

    List<Project> listProjectByType(String type);

    List<ProjectContentIdVO> listProject();

    List<Project> searchByName(String name);

    List<String> listProjectType();

    int insertProjectContent(Integer projectId,List<Integer> contentIdList);
}