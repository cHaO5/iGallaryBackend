/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import com.google.gson.JsonObject;
import j2ee.demo.authorization.annotation.Authorization;
import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;
import io.swagger.annotations.*;
import j2ee.demo.model.UserFollow;
import j2ee.demo.service.FavouritesService;
import j2ee.demo.service.UsersService;
import j2ee.demo.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@CrossOrigin("*")
@Api(value = "users", description = "the users API")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private FavouritesService favouritesService;

    @ApiOperation(value = "注册用户", nickname = "usersPost", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功注册", response = User.class),
            @ApiResponse(code = 409, message = "拥有这个邮箱的用户已经被注册了")})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object>  usersPost(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        User usersEmail = usersService.findByEmail(body.getEmail());
        User usersName = usersService.findByUsername(body.getUsername());
        if (usersEmail != null) {
//            return new Response(409, "Error", "Email has been registered.");
            return new ResponseEntity<>(new ErrorResult("Email has been registered."), HttpStatus.CONFLICT);
        }
        if (usersName != null) {
//            return new Response(409, "Error", "Username has been used.");
            return new ResponseEntity<>(new ErrorResult("Username has been used."), HttpStatus.CONFLICT);
        }
        body.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String password = body.getPassword();
        body.setPassword(Utils.MD5(password + body.getSalt()));
        usersService.addUser(body);
//        return new Response(200, "Success");
        JsonObject userDto = new JsonObject();
        userDto.addProperty("user_id", body.getId());
        userDto.addProperty("username", body.getUsername());
        userDto.addProperty("avatar", body.getAvatar());
        userDto.addProperty("email", body.getEmail());
        return new ResponseEntity<>(userDto.toString(), HttpStatus.CREATED);
    }


    @ApiOperation(value = "查看一个收藏夹", nickname = "usersUserIdFavouritesFavIdGet", notes = "", response = Favourites.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功获取信息", response = Favourites.class),
            @ApiResponse(code = 403, message = "Fav 不是这个人的 ／ 访问权限不够"),
            @ApiResponse(code = 404, message = "不存在这个 Fav")})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}/favourites/{FavId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Object>  usersUserIdFavouritesFavIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FavId") Integer favId) {
        Favourites favourites = favouritesService.findByFavId(favId);
        if (favourites == null) {
            return new ResponseEntity<>(new ErrorResult("不存在这个 Fav"), HttpStatus.CONFLICT);
        }
        System.out.println();
        if (!favourites.getCreator().equals(userId)) {
            return new ResponseEntity<>(new ErrorResult("Fav 不是这个人的 ／ 访问权限不够"), HttpStatus.FORBIDDEN);
        }
//        return new Response(200, "Success", moments);
        JsonObject favDto = new JsonObject();
        favDto.addProperty("Id", favourites.getId());
        favDto.addProperty("Creator", favourites.getCreator());
        favDto.addProperty("Name", favourites.getName());
        return new ResponseEntity<>(favDto.toString(), HttpStatus.OK);
    }


    @ApiOperation(value = "取消关注用户", nickname = "usersUserIdFollowsFollowedUserIdDelete", notes = "", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "取消关注成功"),
            @ApiResponse(code = 404, message = "用户不存在")})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}/follows/{FollowedUserId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Object>  usersUserIdFollowsFollowedUserIdDelete(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FollowedUserId") Integer followedUserId) {
        User followTo = usersService.getUser(followedUserId);
        if (followTo == null) {
            return new ResponseEntity<>(new ErrorResult("用户不存在"), HttpStatus.NOT_FOUND);
        }
        usersService.unfollow(userId, followedUserId);
//        return new Response(200, "Success");
        return new ResponseEntity<>(new CorrectResult("取消关注成功"), HttpStatus.OK);
    }


    @ApiOperation(value = "关注用户", nickname = "usersUserIdFollowsFollowedUserIdPost", notes = "", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "关注成功"),
            @ApiResponse(code = 404, message = "用户不存在"),
            @ApiResponse(code = 409, message = "你已经关注了他...")})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}/follows/{FollowedUserId}",
            method = RequestMethod.POST)
    public ResponseEntity<Object>  usersUserIdFollowsFollowedUserIdPost(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FollowedUserId") Integer followedUserId) {
        User followTo = usersService.getUser(followedUserId);
        if (followTo == null) {
            return new ResponseEntity<>(new ErrorResult("用户不存在"), HttpStatus.NOT_FOUND);
        }
        UserFollow userFollow = usersService.findByUserIdAndFollowTo(userId, followedUserId);
        if (userFollow != null) {
            return new ResponseEntity<>(new ErrorResult("你已经关注了他..."), HttpStatus.CONFLICT);
        }
        usersService.follow(userId, followedUserId);
//        return new Response(200, "Success");
        return new ResponseEntity<>(new CorrectResult("关注成功"), HttpStatus.OK);
    }


    @ApiOperation(value = "获得用户关注的对象", nickname = "usersUserIdFollowsGet", notes = "", response = User.class, responseContainer = "List", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功找到关注的对象", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "用户不存在")})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}/follows",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Object>  usersUserIdFollowsGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        User followTo = usersService.getUser(userId);
        if (followTo == null) {
            return new ResponseEntity<>(new ErrorResult("用户不存在"), HttpStatus.NOT_FOUND);
        }
        List<Integer> users = usersService.getFollow(userId);
//        return new Response(200, "Success", users);
        JsonObject receive = new JsonObject();
        receive.add("user_list", GetJsonContentUtils.transListToJsonArray(users));
        return new ResponseEntity<>(receive.toString(), HttpStatus.OK);
    }


    @ApiOperation(value = "查看用户信息", nickname = "usersUserIdGet", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功查看用户信息", response = User.class)})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Object>  usersUserIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        User user = usersService.getUser(userId);
//        return new Response(200, "Success", user);
        JsonObject userDto = new JsonObject();
        userDto.addProperty("Id", user.getId());
        userDto.addProperty("Description", user.getDescription());
        userDto.addProperty("Avatar", user.getAvatar());
        userDto.addProperty("Email", user.getEmail());
        userDto.addProperty("Username", user.getUsername());
        return new ResponseEntity<>(userDto.toString(), HttpStatus.OK);
    }


    @ApiOperation(value = "修改用户信息", nickname = "usersUserIdPut", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功修改用户信息", response = User.class)})
//    @Authorization
    @RequestMapping(value = "/users/{UserId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Object>  usersUserIdPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        usersService.modifyUser(userId, body);
//        return new Response(200, "Success");
        JsonObject userDto = new JsonObject();
        userDto.addProperty("Id", body.getId());
        userDto.addProperty("Description", body.getDescription());
        userDto.addProperty("Avatar", body.getAvatar());
        userDto.addProperty("Email", body.getEmail());
        userDto.addProperty("Username", body.getUsername());
        return new ResponseEntity<>(userDto.toString(), HttpStatus.OK);
    }

    @ApiOperation(value = "忘记密码", nickname = "usersUserIdPut", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功修改用户信息", response = User.class)})
//    @Authorization
    @RequestMapping(value = "/users/password",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Object>  usersForgetPasswordPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        usersService.forgetPassword(body);
//        return new Response(200, "Success");
        JsonObject userDto = new JsonObject();
        userDto.addProperty("Id", body.getId());
        userDto.addProperty("Description", body.getDescription());
        userDto.addProperty("Avatar", body.getAvatar());
        userDto.addProperty("Email", body.getEmail());
        userDto.addProperty("Username", body.getUsername());
        return new ResponseEntity<>(userDto.toString(), HttpStatus.OK);
    }

}
