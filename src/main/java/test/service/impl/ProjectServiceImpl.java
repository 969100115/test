package test.service.impl;

import org.springframework.beans.BeanUtils;
import test.bean.*;
import test.dto.ProjectDTO;
import test.service.*;
import test.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.vo.ProjectContentIdVO;
import test.vo.ProjectVO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectMapper projectMapper;
    @Resource
    ContentService contentService;

    @Override
    public int insertProject(Project bean) {
        return projectMapper.insert(bean);
    }

    @Override
    public int updateProject(Project bean) {
        return projectMapper.updateByPrimaryKey(bean);
    }

    @Override
    public int deleteProjectById(int id) {
        return projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProjectDTO selectProjectById(Integer id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        List<Content> contentList = contentService.listContentByProjectId(id);
        ProjectDTO projectDTO = new ProjectDTO();
        BeanUtils.copyProperties(project,projectDTO);
        projectDTO.setContentList(contentList);
        return projectDTO;
    }
    @Override
    public List<Project> listProjectByType(String type) {
        return projectMapper.listProjectByType(type);
    }

    @Override
    public List<ProjectContentIdVO> listProject() {
        return projectMapper.listProjectAll();
    }

    @Override
    public List<Project> searchByName(String name) {
        return projectMapper.searchByName(name);
    }

    @Override
    public List<String> listProjectType() {
        return projectMapper.listProjectType();
    }

    @Override
    public int insertProjectContent(Integer projectId,List<Integer> contentIdList){
        projectMapper.deleteRelationByProjectId(projectId);
        for (Integer id:contentIdList){
            projectMapper.insertProjectContent(id,projectId);
        }
        return contentIdList.size();
    }
}