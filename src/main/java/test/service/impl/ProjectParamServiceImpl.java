package test.service.impl;

import org.springframework.stereotype.Service;
import test.bean.ProjectParam;
import test.dao.ProjectMapper;
import test.dao.ProjectParamMapper;
import test.service.ProjectParamService;
import test.service.ProjectService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectParamServiceImpl implements ProjectParamService {
    @Resource
    ProjectParamMapper projectParamMapper;

    @Override
    public List<ProjectParam> listProjectParam(Integer orderId) {
        return  projectParamMapper.listProjectParamByOrderId(orderId);
    }
}
