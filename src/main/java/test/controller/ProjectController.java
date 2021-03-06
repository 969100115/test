package test.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.bean.Content;
import test.bean.Project;
import test.bean.User;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dto.ProjectDTO;
import test.params.AddUserParams;
import test.params.ProjectParams;
import test.params.UploadProjectParams;
import test.service.ContentService;
import test.service.ProjectService;
import test.vo.ContentVO;
import test.vo.ProjectContentIdVO;
import test.vo.ProjectVO;
import test.vo.UserVO;

import java.util.List;

@RestController
@RequestMapping("project/")
@Slf4j
@Api(value = "主题管理")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ContentService contentService;

    @ApiOperation(value = "添加主题内容", httpMethod = "POST")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean addProject(@RequestBody ProjectParams params) {
        Project project = new Project();
        BeanUtils.copyProperties(params, project);
        projectService.insertProject(project);
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(params, projectVO);
        return new ResultBean(projectVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "修改主题信息", httpMethod = "POST")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBean updateProject(@RequestBody UploadProjectParams params) {
        Project project = new Project();
        BeanUtils.copyProperties(params, project);
        projectService.insertProjectContent(params.getId(),params.getContentIdList());
        projectService.updateProject(project);
        ProjectContentIdVO projectVO = new ProjectContentIdVO();
        BeanUtils.copyProperties(params, projectVO);
        return new ResultBean(projectVO, ResultEnum.SUCCESS);
    }


    @ApiOperation(value = "查看主题详情", httpMethod = "POST")
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public ResultBean projectInfo(@RequestBody JSONObject params) {
        ProjectDTO projectDTO = projectService.selectProjectById(params.getInteger("id"));
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(projectDTO, projectVO);
        return new ResultBean(projectVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "通过类型筛选主题", httpMethod = "POST")
    @RequestMapping(value = "listByType", method = RequestMethod.POST)
    public ResultBean listProjectByType(@RequestBody JSONObject params) {
        List<Project> projectList = projectService.listProjectByType(params.getString("type"));
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查看所有主题", httpMethod = "POST")
    @RequestMapping(value = "listAll", method = RequestMethod.POST)
    public ResultBean listAllProject(@RequestBody JSONObject params) {
        List<ProjectContentIdVO> projectList = projectService.listProject();
        for (ProjectContentIdVO projectVO:projectList){
            Integer projectId = projectVO.getId();
            List<Integer> contentIdList = contentService.listContentIdByProjectId(projectId);
            projectVO.setContentIdList(contentIdList);
        }
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "通过名字检索主题", httpMethod = "POST")
    @RequestMapping(value = "searchByName", method = RequestMethod.POST)
    public ResultBean searchByName(@RequestBody JSONObject params) {
        List<Project> projectList = projectService.searchByName(params.getString("name"));
        return new ResultBean(projectList, ResultEnum.SUCCESS);
    }


    @ApiOperation(value = "查看所有主题类型", httpMethod = "POST")
    @RequestMapping(value = "listProjectType", method = RequestMethod.POST)
    public ResultBean listProjectType(@RequestBody JSONObject params) {
        List<String> typeList = projectService.listProjectType();
        return new ResultBean(typeList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "删除主题", httpMethod = "POST")
    @RequestMapping(value = "delByProjectId", method = RequestMethod.POST)
    public ResultBean delByProjectId(@RequestBody JSONObject params) {
        projectService.deleteProjectById(params.getInteger("id"));
        return new ResultBean(true, ResultEnum.SUCCESS);
    }
}
