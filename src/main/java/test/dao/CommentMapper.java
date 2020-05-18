package test.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import test.bean.Comment;
import test.bean.Content;
import test.common.BaseMapper;
import test.vo.CommentVO;

import java.util.List;


@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentVO> listCommentByType(@Param("type") String type, @Param("projectId") Integer projectId);
    int pickComment(@Param("project") Integer projectId);
}