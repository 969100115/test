package test.service;
import test.bean.*;
public interface TestMethodService{
int insertTestMethod ( TestMethod bean );
int updateTestMethod ( TestMethod bean );
int deleteTestMethodById ( int id);
public TestMethod selectTestMethodById ( int id);
}