/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import j2ee.demo.model.Favourites;
import io.swagger.annotations.*;
import j2ee.demo.service.FavouritesService;
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

@Api(value = "favourites", description = "the favourites API")
@RestController
public class FavouritesController {
    @Autowired
    private FavouritesService favouritesService;

    @ApiOperation(value = "", nickname = "favouritesUserIdDelete", notes = "删除一个收藏夹", response = Favourites.class, tags = {"favourite",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功创建收藏夹", response = Favourites.class),
            @ApiResponse(code = 409, message = "收藏夹名字冲突")})
    @RequestMapping(value = "/favourites/{UserId}/{FavouritesId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    Response favouritesUserIdDelete(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId, @PathVariable("FavouritesId") Integer favouritesId) {
        favouritesService.deleteFavourite(userId, favouritesId);
        return new Response(200, "Success");
    }


    @ApiOperation(value = "", nickname = "favouritesUserIdPost", notes = "创建一个收藏夹", response = Favourites.class, tags = {"favourite",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功创建收藏夹", response = Favourites.class),
            @ApiResponse(code = 409, message = "收藏夹名字冲突")})
    @RequestMapping(value = "/favourites/{UserId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Response favouritesUserIdPost(@ApiParam(value = "", required = true) @Valid @RequestBody Favourites body, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        favouritesService.addFavourite(userId, body);
        return new Response(201, "Success");
    }

}
