package test.service;

import test.bean.*;
import test.dto.UpdatePasswordDTO;
import test.dto.UserLoginDTO;
import test.params.UpdatePasswordParams;

public interface UserService {
    int insertUser(User bean);

    int updateUser(User bean);

    int deleteUserById(int id);

    User selectUserById(int id);

    User updateUserPassword(UpdatePasswordDTO updatePasswordDTO);

    User login(UserLoginDTO userLoginDTO);
}