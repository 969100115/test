package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import test.bean.*;
import test.dto.UpdatePasswordDTO;
import test.params.UpdatePasswordParams;
import test.service.*;
import test.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User bean) {
        return userMapper.insert(bean);
    }

    @Override
    public int updateUser(User bean) {
        return userMapper.updateByPrimaryKey(bean);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User updateUserPassword(UpdatePasswordDTO updatePasswordDTO) {
        return userMapper.updatePassword(updatePasswordDTO);
    }
}