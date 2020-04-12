package test.service.impl;
import test.bean.*;
import test.service.*;
import test.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
@Service
public class TestMethodServiceImpl implements TestMethodService{
@Resource
TestMethodMapper testMethodMapper;
@Override
public int insertTestMethod ( TestMethod bean ){
return testMethodMapper.insert(bean);
    }
@Override
public int updateTestMethod ( TestMethod bean ){
return testMethodMapper.updateByPrimaryKey(bean);
    }
@Override
public int deleteTestMethodById ( int id){
return testMethodMapper.deleteByPrimaryKey(id);
    }
@Override
public TestMethod selectTestMethodById ( int id){
return testMethodMapper.selectByPrimaryKey(id);
    }
}