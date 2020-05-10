package test.service.impl;

import org.springframework.stereotype.Service;
import test.bean.Comment;
import test.bean.Content;
import test.bean.Order;
import test.dao.CommentMapper;
import test.dao.OrderMapper;
import test.dto.CommentSelectDTO;
import test.service.CommentService;
import test.service.OrderService;
import test.vo.MyOrderListVO;
import test.vo.OrderVO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public int insertComment(Comment bean) {
        return commentMapper.insert(bean);
    }

    @Override
    public int updateComment(Comment bean) {
        return commentMapper.updateByPrimaryKey(bean);
    }

    @Override
    public int deleteCommentById(int id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Comment selectCommentById(int id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> listCommentByType(CommentSelectDTO commentSelectDTO) {
        return commentMapper.listCommentByType(commentSelectDTO.getType(),commentSelectDTO.getProjectId());
    }

    @Override
    public List<Comment> listComment() {
        return commentMapper.selectAll();
    }

    @Override
    public boolean pickComment(int projectId) {
        commentMapper.pickComment(projectId);
        return false;
    }


}