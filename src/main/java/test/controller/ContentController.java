package test.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import test.params.ContentParams;
import test.params.ProjectParams;
import test.service.ContentService;
import test.service.ProjectService;
import test.vo.ContentVO;
import test.vo.ProjectVO;
import test.vo.UserVO;

import java.util.List;

@RestController
@RequestMapping("content/")
@Slf4j
@Api(value = "内容管理")
public class ContentController {

    @Autowired
    ContentService contentService;

    @ApiOperation(value = "添加测试内容", httpMethod = "POST")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean addContent(@RequestBody ContentParams params) {
        Content content = new Content();
        BeanUtils.copyProperties(params, content);
        contentService.insertContent(content);
        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(params, contentVO);
        return new ResultBean(contentVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查看测试内容详情", httpMethod = "POST")
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public ResultBean contentInfo(@RequestBody JSONObject params) {
        Content content = contentService.selectContentById(params.getInteger("id"));
        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(content, contentVO);
        return new ResultBean(contentVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "获取内容列表通过type", httpMethod = "POST")
    @RequestMapping(value = "listByType", method = RequestMethod.POST)
    public ResultBean listContentByType(@RequestBody JSONObject params) {
        List<Content> contentList = contentService.listContentByType(params.getString("type"));
        return new ResultBean(contentList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "获取全部内容列表", httpMethod = "POST")
    @RequestMapping(value = "listAll", method = RequestMethod.POST)
    public ResultBean listAllContent(@RequestBody JSONObject params) {
        List<Content> contentList = contentService.listContent();
        return new ResultBean(contentList, ResultEnum.SUCCESS);
    }

}
