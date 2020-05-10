package test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import test.bean.User;
import test.common.BaseMapper;
import test.dto.UpdatePasswordDTO;
import test.dto.UserLoginDTO;


@Repository
public interface UserMapper extends BaseMapper<User> {
    Integer updatePassword(UpdatePasswordDTO updatePasswordDTO);

    User getUserByPhone(@Param("phone") String phone );
}