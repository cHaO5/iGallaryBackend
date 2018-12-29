package j2ee.demo.controller;

import com.google.gson.JsonObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import j2ee.demo.authorization.annotation.Authorization;
import j2ee.demo.authorization.annotation.CurrentUser;
import j2ee.demo.authorization.manager.TokenManager;
import j2ee.demo.authorization.model.TokenModel;
import j2ee.demo.configuration.ResultStatus;
import j2ee.demo.mapper.UserMapper;
import j2ee.demo.model.User;
//import j2ee.demo.model.ResultModel;
//import j2ee.demo.repository.UserRepository;
//import com.wordnik.swagger.annotations.ApiImplicitParam;
//import com.wordnik.swagger.annotations.ApiImplicitParams;
//import com.wordnik.swagger.annotations.ApiOperation;
import j2ee.demo.service.UsersService;
import j2ee.demo.utils.CorrectResult;
import j2ee.demo.utils.ErrorResult;
import j2ee.demo.utils.Response;
import j2ee.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = usersService.findByUsername(username);
        if (user == null ||  //未注册
                !user.getPassword().equals(Utils.MD5(password + user.getSalt()))) {  //密码错误
            //提示用户名或密码错误
//            return new Response(401, "Error", ResultStatus.USERNAME_OR_PASSWORD_ERROR);
            return new ResponseEntity<>(new ErrorResult(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getId());
//        return new Response(200, "Success", model);

        JsonObject userDto = new JsonObject();
        userDto.addProperty("user_id", user.getId());
        userDto.addProperty("username", user.getUsername());
        userDto.addProperty("avatar", user.getAvatar());
        userDto.addProperty("email", user.getEmail());
        JsonObject receive = new JsonObject();
        receive.addProperty("token", model.getToken());
        receive.add("user_dto", userDto);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(receive.toString(), responseHeaders, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE)
//    @Authorization
    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Object> logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
//        return new Response(200, "Success");
        return new ResponseEntity<>(new CorrectResult(ResultStatus.SUCCESS), HttpStatus.OK);
    }

}
