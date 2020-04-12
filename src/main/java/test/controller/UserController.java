package test.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import test.bean.User;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dto.UpdatePasswordDTO;
import test.params.AddUserParams;
import test.params.UpdatePasswordParams;
import test.service.UserService;
import test.vo.UserVO;

@RestController
@RequestMapping("user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public ResultBean addUser(@RequestBody AddUserParams params){
        User user = new User();
        BeanUtils.copyProperties(params,user);
        userService.insertUser(user);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(params,userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("info")
    public ResultBean userInfo(@RequestBody JSONObject params){
        User user = userService.selectUserById(params.getInteger("id"));
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

    @RequestMapping("updatePassword")
    public ResultBean updatePassword(@RequestBody UpdatePasswordParams params){
        UpdatePasswordDTO updatePasswordDTO = new UpdatePasswordDTO();
        BeanUtils.copyProperties(params,updatePasswordDTO);
        User user = userService.updateUserPassword(updatePasswordDTO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

}
