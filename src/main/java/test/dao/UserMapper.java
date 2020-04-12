package test.dao;

import org.springframework.stereotype.Repository;
import test.bean.User;
import test.common.BaseMapper;
import test.dto.UpdatePasswordDTO;


@Repository
public interface UserMapper extends BaseMapper<User> {
    User updatePassword(UpdatePasswordDTO updatePasswordDTO);
}