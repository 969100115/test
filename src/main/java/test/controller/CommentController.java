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
import test.bean.Comment;
import test.bean.Order;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dto.CommentSelectDTO;
import test.params.CommentParams;
import test.params.CommentSelectParams;
import test.params.OrderParams;
import test.service.CommentService;
import test.service.OrderService;
import test.vo.CommentVO;
import test.vo.MyOrderListVO;
import test.vo.OrderVO;

import java.util.List;

@RestController
@RequestMapping("comment/")
@Slf4j
@Api(value = "评论管理")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation(value = "新建评论", httpMethod = "POST")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean addContent(@RequestBody CommentParams params) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(params, comment);
        commentService.insertComment(comment);
        CommentVO commentVO = new CommentVO();
        BeanUtils.copyProperties(params, commentVO);
        return new ResultBean(commentVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查询主题评论，按type进行筛选，如type为空则查询全部", httpMethod = "POST")
    @RequestMapping(value = "listByProjectId", method = RequestMethod.POST)
    public ResultBean listByProjectId(@RequestBody CommentSelectParams params) {
        CommentSelectDTO comment = new CommentSelectDTO();
        BeanUtils.copyProperties(params, comment);
        List<Comment> commentList = commentService.listCommentByType(comment);
        return new ResultBean(commentList, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "评论点赞", httpMethod = "POST")
    @RequestMapping(value = "pick", method = RequestMethod.POST)
    public ResultBean pickComment(@RequestBody JSONObject params) {
        commentService.pickComment(params.getInteger("projectId"));
        return new ResultBean("成功", ResultEnum.SUCCESS);
    }



}
