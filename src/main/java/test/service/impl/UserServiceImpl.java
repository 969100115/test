package test.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import test.bean.*;
import test.dto.UpdatePasswordDTO;
import test.dto.UserLoginDTO;
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
        User user = userMapper.getUserByPhone(bean.getPhone());
        if(user!=null){
            return 0;
        }
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
        User user = userMapper.selectByPrimaryKey(updatePasswordDTO.getId());
        userMapper.updatePassword(updatePasswordDTO);
        return user;
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userMapper.getUserByPhone(userLoginDTO.getPhone());
        if (user == null || StringUtils.isBlank(userLoginDTO.getPassword()) || !user.getPassword().equals(userLoginDTO.getPassword())) {
            return null;
        }else {
            return user;
        }
    }
}