package test.service;

import test.bean.Comment;
import test.bean.Content;
import test.bean.Order;
import test.dao.CommentMapper;
import test.dao.OrderMapper;
import test.dto.CommentSelectDTO;
import test.vo.CommentVO;
import test.vo.MyOrderListVO;

import javax.annotation.Resource;
import java.util.List;

public interface CommentService {

    int insertComment(Comment bean);


    int updateComment(Comment bean);


    int deleteCommentById(int id);


    Comment selectCommentById(int id);

    List<CommentVO> listCommentByType(CommentSelectDTO commentSelectDTO);

    List<Comment> listComment();

    boolean pickComment(int projectId);


}