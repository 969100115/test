package test.service.impl;

import org.springframework.stereotype.Service;
import test.bean.*;
import test.service.*;
import test.dao.*;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    ContentMapper contentMapper;

    @Override
    public int insertContent(Content bean) {
        return contentMapper.insert(bean);
    }

    @Override
    public int updateContent(Content bean) {
        return contentMapper.updateByPrimaryKey(bean);
    }

    @Override
    public int deleteContentById(int id) {
        return contentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Content selectContentById(int id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Content> listContentByType(String type) {
        return contentMapper.listContentByType(type);
    }

    @Override
    public List<Content> listContent() {
        return contentMapper.selectAll();
    }

    @Override
    public List<Content> listContentByProjectId(Integer projectId) {
        return contentMapper.listContentByProjectId(projectId);
    }
    @Override
    public List<Integer> listContentIdByProjectId(Integer projectId) {
        return contentMapper.listContentIdByProjectId(projectId);
    }
}