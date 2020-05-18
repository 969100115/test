package test.service;

import test.bean.*;

import java.util.List;

public interface ContentService {
    int insertContent(Content bean);

    int updateContent(Content bean);

    int deleteContentById(int id);

    Content selectContentById(int id);

    List<Content> listContentByType(String type);

    List<Content> listContent();

    List<Content> listContentByProjectId(Integer projectId);

    List<Integer> listContentIdByProjectId(Integer projectId);
}