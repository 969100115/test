package test.dao;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import org.springframework.stereotype.Repository;
import test.dao.BaseMapper;
import test.bean.TestA;


@Repository
public interface TestAMapper extends BaseMapper<TestA> {
}