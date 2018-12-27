/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;
import io.swagger.annotations.*;
import j2ee.demo.service.UsersService;
import j2ee.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Api(value = "users", description = "the users API")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "注册用户", nickname = "usersPost", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Already created the user.", response = User.class),
            @ApiResponse(code = 409, message = "拥有这个邮箱的用户已经被注册了")})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Response usersPost(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        usersService.addUser(body);
        return new Response(200, "Success");
    }


    @ApiOperation(value = "", nickname = "usersUserIdFavouritesFavIdGet", notes = "查看一个收藏夹", response = Favourites.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功获取信息", response = Favourites.class),
            @ApiResponse(code = 403, message = "Fav 不是这个人的 ／ 访问权限不够"),
            @ApiResponse(code = 404, message = "不存在这个 Fav")})
    @RequestMapping(value = "/users/{UserId}/favourites/{FavId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Response usersUserIdFavouritesFavIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FavId") Integer favId) {
        List<Integer> moments = usersService.getFavourite(userId, favId);
        return new Response(200, "Success", moments);
    }


    @ApiOperation(value = "让用户 UserId 取消关注用户 FollowedUserId", nickname = "usersUserIdFollowsFollowedUserIdDelete", notes = "", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "取消关注成功"),
            @ApiResponse(code = 404, message = "某个用户不存在")})
    @RequestMapping(value = "/users/{UserId}/follows/{FollowedUserId}",
            method = RequestMethod.DELETE)
    Response usersUserIdFollowsFollowedUserIdDelete(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FollowedUserId") Integer followedUserId) {
        usersService.unfollow(userId, followedUserId);
        return new Response(200, "Success");
    }


    @ApiOperation(value = "让用户 UserId 关注用户 FollowedUserId", nickname = "usersUserIdFollowsFollowedUserIdPost", notes = "", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "关注成功"),
            @ApiResponse(code = 404, message = "某个用户不存在"),
            @ApiResponse(code = 409, message = "你已经关注了他...")})
    @RequestMapping(value = "/users/{UserId}/follows/{FollowedUserId}",
            method = RequestMethod.POST)
    Response usersUserIdFollowsFollowedUserIdPost(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @ApiParam(value = "", required = true) @PathVariable("FollowedUserId") Integer followedUserId) {
        usersService.follow(userId, followedUserId);
        return new Response(200, "Success");
    }


    @ApiOperation(value = "获得用户 follow 的对象", nickname = "usersUserIdFollowsGet", notes = "", response = User.class, responseContainer = "List", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功找到 follow 的对象", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "用户不存在")})
    @RequestMapping(value = "/users/{UserId}/follows",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Response usersUserIdFollowsGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        List<Integer> users = usersService.getFollow(userId);
        return new Response(200, "Success", users);
    }


    @ApiOperation(value = "查看用户信息", nickname = "usersUserIdGet", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功查看用户信息", response = User.class)})
    @RequestMapping(value = "/users/{UserId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Response usersUserIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        User user = usersService.getUser(userId);
        return new Response(200, "Success", user);
    }


    @ApiOperation(value = "修改用户信息", nickname = "usersUserIdPut", notes = "", response = User.class, tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功修改用户信息", response = User.class)})
    @RequestMapping(value = "/users/{UserId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    Response usersUserIdPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        usersService.modifyUser(userId, body);
        return new Response(200, "Success");
    }

}