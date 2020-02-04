package test.dao;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import org.springframework.stereotype.Repository;
import test.dao.BaseMapper;
import test.bean.TestA;
import org.springframework.stereotype.Repository;
import test.dao.BaseMapper;
import test.bean.TestB;
import org.springframework.stereotype.Repository;
import test.dao.BaseMapper;
import test.bean.TestC;


@Repository
public interface TestCMapper extends BaseMapper<TestC> {
}