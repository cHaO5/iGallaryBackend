/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import j2ee.demo.authorization.annotation.Authorization;
import j2ee.demo.model.Moment;
import io.swagger.annotations.*;
import j2ee.demo.model.User;
import j2ee.demo.model.UserLikes;
import j2ee.demo.service.FavouritesService;
import j2ee.demo.service.MomentsService;
import j2ee.demo.service.UsersService;
import j2ee.demo.utils.CorrectResult;
import j2ee.demo.utils.ErrorResult;
import j2ee.demo.utils.GetJsonContentUtils;
import j2ee.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@CrossOrigin("*")
@Api(value = "moments", description = "the moments API")
@RestController
public class MomentsController {
    @Autowired
    private MomentsService momentsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private FavouritesService favouritesService;

    @ApiOperation(value = "删除动态", nickname = "momentsMomentIdDelete", notes = "", tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "动态删除成功"),
            @ApiResponse(code = 404, message = "某个动态不存在")})
//    @Authorization
    @RequestMapping(value = "/moments/{MomentId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Object>  momentsMomentIdDelete(@ApiParam(value = "", required = true) @PathVariable("MomentId") Integer momentId) {
        Moment moment = momentsService.findByMomentId(momentId);
        if (moment == null) {
            return new ResponseEntity<>(new ErrorResult("动态不存在"), HttpStatus.NOT_FOUND);
        }
        momentsService.deleteMomentById(momentId);
//        return new Response(200, "Success");
        return new ResponseEntity<>(new CorrectResult("动态删除成功"), HttpStatus.OK);
    }


    @ApiOperation(value = "转发", nickname = "momentsMomentIdForwardUserIdPost", notes = "", tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "转发成功"),
            @ApiResponse(code = 404, message = "用户或动态不存在")})
//    @Authorization
    @RequestMapping(value = "/moments/{MomentId}/forward/{UserId}",
            method = RequestMethod.POST)
    public ResponseEntity<Object>  momentsMomentIdForwardUserIdPost(@ApiParam(value = "", required = true) @PathVariable("MomentId") Integer momentId, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        Moment moment = momentsService.findByMomentId(momentId);
        User user = usersService.getUser(userId);
        if (moment == null || user == null) {
            return new ResponseEntity<>(new ErrorResult("某个用户或分享不存在"), HttpStatus.NOT_FOUND);
        }
        momentsService.forward(momentId, userId);
//        return new Response(201, "Success");
        return new ResponseEntity<>(new CorrectResult("转发成功"), HttpStatus.CREATED);
    }


    @ApiOperation(value = "取消点赞", nickname = "momentsMomentIdLikesUserIdDelete", notes = "", tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "点赞取消成功"),
            @ApiResponse(code = 404, message = "某个用户或动态不存在")})
//    @Authorization
    @RequestMapping(value = "/moments/{MomentId}/likes/{UserId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Object>  momentsMomentIdLikesUserIdDelete(@ApiParam(value = "", required = true) @PathVariable("MomentId") Integer momentId, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        Moment moment = momentsService.findByMomentId(momentId);
        User user = usersService.getUser(userId);
        if (moment == null || user == null) {
            return new ResponseEntity<>(new ErrorResult("某个用户或分享不存在"), HttpStatus.NOT_FOUND);
        }
        momentsService.deleteMomentLikes(momentId, userId);
//        return new Response(200, "Success");
        return new ResponseEntity<>(new CorrectResult("点赞取消成功"), HttpStatus.OK);
    }


    @ApiOperation(value = "点赞", nickname = "momentsMomentIdLikesUserIdPost", notes = "", tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "关注成功"),
            @ApiResponse(code = 404, message = "某个用户不存在"),
            @ApiResponse(code = 409, message = "你已经关注了他...")})
//    @Authorization
    @RequestMapping(value = "/moments/{MomentId}/likes/{UserId}",
            method = RequestMethod.POST)
    public ResponseEntity<Object>  momentsMomentIdLikesUserIdPost(@ApiParam(value = "", required = true) @PathVariable("MomentId") Integer momentId, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        User user = usersService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(new ErrorResult("某个用户不存在"), HttpStatus.NOT_FOUND);
        }
        UserLikes userLikes = momentsService.findLikesByMomentIdAndUserId(momentId, userId);
        if (userLikes != null) {
            return new ResponseEntity<>(new ErrorResult("你已经关注了他..."), HttpStatus.CONFLICT);
        }
        momentsService.addMomentLikes(momentId, userId);
//        return new Response(201, "Success");
        return new ResponseEntity<>(new CorrectResult("关注成功"), HttpStatus.CREATED);
    }


    @ApiOperation(value = "用户发表动态", nickname = "momentsPost", notes = "", response = Moment.class, tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Post moment successfully.", response = Moment.class)})
//    @Authorization
    @RequestMapping(value = "/moments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object>  momentsPost(@ApiParam(value = "", required = true) @Valid @RequestBody Moment body) {
        momentsService.addMoment(body);
//        return new Response(201, "Success");
        JsonObject momentDto = new JsonObject();
        momentDto.addProperty("Id", body.getId());
        momentDto.addProperty("Content", body.getContent());
        momentDto.addProperty("Creator", body.getCreator());
        momentDto.addProperty("LikeNum", body.getLikeNum());
        momentDto.addProperty("ForwardNum", body.getForwardNum());
        momentDto.addProperty("FavouriteNum", body.getFavouriteNum());
        momentDto.addProperty("CommentNum", body.getCommentNum());
        momentDto.addProperty("Time", body.getTime());
        momentDto.addProperty("Tags", body.getTags());
        JsonObject receive = new JsonObject();
        receive.addProperty("msg", "Post moment successfully.");
        receive.add("data", momentDto);
        return new ResponseEntity<>(receive.toString(), HttpStatus.CREATED);
    }


    @ApiOperation(value = "修改动态内容", nickname = "momentsPut", notes = "", response = Moment.class, tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功修改动态", response = Moment.class)})
//    @Authorization
    @RequestMapping(value = "/moments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Object>  momentsPut(@ApiParam(value = "", required = true) @Valid @RequestBody Moment body) {
        momentsService.modifyMoment(body);
        JsonObject momentDto = new JsonObject();
        momentDto.addProperty("Id", body.getId());
        momentDto.addProperty("Content", body.getContent());
        momentDto.addProperty("Creator", body.getCreator());
        momentDto.addProperty("LikeNum", body.getLikeNum());
        momentDto.addProperty("ForwardNum", body.getForwardNum());
        momentDto.addProperty("FavouriteNum", body.getFavouriteNum());
        momentDto.addProperty("CommentNum", body.getCommentNum());
        momentDto.addProperty("Time", body.getTime());
        momentDto.addProperty("Tags", body.getTags());
//        return new Response(201, "Success");
        return new ResponseEntity<>(momentDto.toString(), HttpStatus.OK);
    }


    @ApiOperation(value = "获得用户首页动态", nickname = "momentsUserIdGet", notes = "", response = Moment.class, responseContainer = "List", tags = {"moment",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功找到首页动态", response = Moment.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "用户不存在")})
//    @Authorization
    @RequestMapping(value = "/moments/{UserId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Object>  momentsUserIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        User user = usersService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(new ErrorResult("某个用户不存在"), HttpStatus.NOT_FOUND);
        }
        List<Moment> data = momentsService.getMoment(userId);
        JsonArray jsonArray = new JsonArray();
        for (Moment moment : data) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Id", moment.getId());
            jsonObject.addProperty("Content", moment.getContent());
            jsonObject.addProperty("Creator", moment.getCreator());
            jsonObject.addProperty("LikeNum", moment.getLikeNum());
            jsonObject.addProperty("ForwardNum", moment.getForwardNum());
            jsonObject.addProperty("FavouriteNum", moment.getFavouriteNum());
            jsonObject.addProperty("CommentNum", moment.getCommentNum());
            jsonObject.addProperty("Time", moment.getTime());
            jsonObject.addProperty("Tags", moment.getTags());
            UserLikes userLikes = momentsService.findLikesByMomentIdAndUserId(moment.getId(), userId);
            if (userLikes == null) {
                jsonObject.addProperty("LikesStatus", 0);
            } else {
                jsonObject.addProperty("LikesStatus", 1);
            }
            Integer checkId = favouritesService.findMomentFavouriteByUserIdAndMomentId(userId, moment.getId());
            if (checkId == null) {
                jsonObject.addProperty("FavouriteStatus", 0);
            } else {
                jsonObject.addProperty("FavouriteStatus", 1);
            }
            jsonArray.add(jsonObject);
        }
//        return new Response(200, "Success", data);
        JsonObject receive = new JsonObject();
//        receive.add("data", GetJsonContentUtils.transListToJsonArray(data));
        receive.add("data", jsonArray);
        return new ResponseEntity<>(receive.toString(), HttpStatus.OK);
    }

}
