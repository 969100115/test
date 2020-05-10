package test.controller;


import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.bean.User;
import test.common.ResultBean;
import test.common.ResultEnum;
import test.dto.UpdatePasswordDTO;
import test.dto.UserLoginDTO;
import test.params.AddUserParams;
import test.params.UpdatePasswordParams;
import test.params.UserLoginParams;
import test.service.UserService;
import test.vo.UserVO;

@RestController
@RequestMapping("user/")
@Slf4j
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册用户", httpMethod = "POST")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean addUser(@RequestBody AddUserParams params) {
        User user = new User();
        BeanUtils.copyProperties(params, user);
        int a = userService.insertUser(user);
        if(a==0){
            return new ResultBean("用户已注册",ResultEnum.REPEAT);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(params, userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "查看用户详情", httpMethod = "POST")
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public ResultBean userInfo(@RequestBody JSONObject params) {
        User user = userService.selectUserById(params.getInteger("id"));
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "更新密码", httpMethod = "POST")
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public ResultBean updatePassword(@RequestBody UpdatePasswordParams params) {
        UpdatePasswordDTO updatePasswordDTO = new UpdatePasswordDTO();
        BeanUtils.copyProperties(params, updatePasswordDTO);
        User user = userService.updateUserPassword(updatePasswordDTO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

    @ApiOperation(value = "用户登录", httpMethod = "POST")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBean userLogin(@RequestBody UserLoginParams params) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        BeanUtils.copyProperties(params, userLoginDTO);
        User user = userService.login(userLoginDTO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return new ResultBean(userVO, ResultEnum.SUCCESS);
    }

}
