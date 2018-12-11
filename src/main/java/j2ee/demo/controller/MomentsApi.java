/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import j2ee.demo.model.Moment;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Api(value = "moments", description = "the moments API")
public interface MomentsApi {

    @ApiOperation(value = "删除动态", nickname = "momentsMomentIdDelete", notes = "", tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "动态删除成功"),
        @ApiResponse(code = 404, message = "某个动态不存在") })
    @RequestMapping(value = "/moments/{MomentId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> momentsMomentIdDelete(@ApiParam(value = "",required=true) @PathVariable("MomentId") Integer momentId);


    @ApiOperation(value = "点赞", nickname = "momentsMomentIdForwardUserIdPost", notes = "", tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "转发成功"),
        @ApiResponse(code = 404, message = "用户或动态不存在") })
    @RequestMapping(value = "/moments/{MomentId}/forward/{UserId}",
        method = RequestMethod.POST)
    ResponseEntity<Void> momentsMomentIdForwardUserIdPost(@ApiParam(value = "",required=true) @PathVariable("MomentId") Integer momentId,@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId);


    @ApiOperation(value = "取消点赞", nickname = "momentsMomentIdLikesUserIdDelete", notes = "", tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "点赞取消成功"),
        @ApiResponse(code = 404, message = "某个用户或动态不存在") })
    @RequestMapping(value = "/moments/{MomentId}/likes/{UserId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> momentsMomentIdLikesUserIdDelete(@ApiParam(value = "",required=true) @PathVariable("MomentId") Integer momentId,@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId);


    @ApiOperation(value = "点赞", nickname = "momentsMomentIdLikesUserIdPost", notes = "", tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "关注成功"),
        @ApiResponse(code = 404, message = "某个用户不存在"),
        @ApiResponse(code = 409, message = "你已经关注了他...") })
    @RequestMapping(value = "/moments/{MomentId}/likes/{UserId}",
        method = RequestMethod.POST)
    ResponseEntity<Void> momentsMomentIdLikesUserIdPost(@ApiParam(value = "",required=true) @PathVariable("MomentId") Integer momentId,@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId);


    @ApiOperation(value = "用户发表动态", nickname = "momentsPost", notes = "", response = Moment.class, tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Post moment successfully.", response = Moment.class) })
    @RequestMapping(value = "/moments",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Moment> momentsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Moment body);


    @ApiOperation(value = "修改动态内容", nickname = "momentsPut", notes = "", response = Moment.class, tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "成功修改动态", response = Moment.class) })
    @RequestMapping(value = "/moments",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Moment> momentsPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Moment body);


    @ApiOperation(value = "获得用户首页动态", nickname = "momentsUserIdGet", notes = "", response = Moment.class, responseContainer = "List", tags={ "moment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "成功找到首页动态", response = Moment.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "用户不存在") })
    @RequestMapping(value = "/moments/{UserId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Moment>> momentsUserIdGet(@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId);

}