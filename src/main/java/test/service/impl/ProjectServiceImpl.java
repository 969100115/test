package test.service.impl;

import org.springframework.beans.BeanUtils;
import test.bean.*;
import test.dto.ProjectDTO;
import test.service.*;
import test.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Project> listProject() {
        return projectMapper.selectAll();
    }

    @Override
    public List<Project> searchByName(String name) {
        return projectMapper.searchByName(name);
    }
}