package test.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.bean.Content;
import test.bean.Project;
import test.bean.User;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dto.ProjectDTO;
import test.params.AddUserParams;
import test.params.ProjectParams;
import test.service.ProjectService;
import test.vo.ContentVO;
import test.vo.ProjectVO;
import test.vo.UserVO;

import java.util.List;

@RestController
@RequestMapping("project/")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("add")
    public ResultBean addProject (@RequestBody ProjectParams params){
        Project project = new Project();
        BeanUtils.copyProperties(params,project);
        projectService.insertProject(project);
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(params,projectVO);
        return new ResultBean(projectVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("info")
    public ResultBean projectInfo(@RequestBody JSONObject params){
        ProjectDTO projectDTO = projectService.selectProjectById(params.getInteger("id"));
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(projectDTO,projectVO);
        return new ResultBean(projectVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("listByType")
    public ResultBean listProjectByType (@RequestBody ProjectParams params){
        List<Project> projectList = projectService.listProjectByType(params.getType());
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }

    @RequestMapping("listAll")
    public ResultBean listAllProject (@RequestBody ProjectParams params){
        List<Project> projectList = projectService.listProject();
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }

    @RequestMapping("searchByName")
    public ResultBean searchByName (@RequestBody ProjectParams params){
        List<Project> projectList = projectService.searchByName(params.getName());
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }

}
