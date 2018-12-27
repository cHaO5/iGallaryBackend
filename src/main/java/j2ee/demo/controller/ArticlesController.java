/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package j2ee.demo.controller;

import j2ee.demo.model.Article;
import io.swagger.annotations.*;
import j2ee.demo.service.ArticleService;
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

@Api(value = "articles", description = "the articles API")
@RestController
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "删除分享", nickname = "articlesArticleIdDelete", notes = "", tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "动态删除成功"),
            @ApiResponse(code = 404, message = "某个分享不存在")})
    @RequestMapping(value = "/articles/{ArticleId}",
            method = RequestMethod.DELETE)
    Response articlesArticleIdDelete(@ApiParam(value = "", required = true) @PathVariable("ArticleId") Integer articleId) {
        articleService.deleteArticleById(articleId);
        return new Response(200, "Success");
    }


    @ApiOperation(value = "取消点赞", nickname = "articlesArticleIdLikesUserIdDelete", notes = "", tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "点赞取消成功"),
            @ApiResponse(code = 404, message = "某个用户或分享不存在")})
    @RequestMapping(value = "/articles/{ArticleId}/likes/{UserId}",
            method = RequestMethod.DELETE)
    Response articlesArticleIdLikesUserIdDelete(@ApiParam(value = "", required = true) @PathVariable("ArticleId") Integer articleId, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        articleService.addArticleLikes(articleId, userId);
        return new Response(201, "Success");
    }


    @ApiOperation(value = "点赞", nickname = "articlesArticleIdLikesUserIdPost", notes = "", tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "关注成功"),
            @ApiResponse(code = 404, message = "某个用户或分享不存在"),
            @ApiResponse(code = 409, message = "你已经关注了这篇分享...")})
    @RequestMapping(value = "/articles/{ArticleId}/likes/{UserId}",
            method = RequestMethod.POST)
    Response articlesArticleIdLikesUserIdPost(@ApiParam(value = "", required = true) @PathVariable("ArticleId") Integer articleId, @ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        articleService.deleteArticleLikes(articleId, userId);
        return new Response(201, "Success");
    }


    @ApiOperation(value = "用户发表分享", nickname = "articlesPost", notes = "", response = Article.class, tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Post article successfully.", response = Article.class)})
    @RequestMapping(value = "/articles",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Response articlesPost(@ApiParam(value = "", required = true) @Valid @RequestBody Article body) {
        articleService.addArticle(body);
        return new Response(201, "Post article successfully.");
    }


    @ApiOperation(value = "修改用户信息", nickname = "articlesPut", notes = "", response = Article.class, tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功修改分享", response = Article.class)})
    @RequestMapping(value = "/articles",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    Response articlesPut(@ApiParam(value = "", required = true) @Valid @RequestBody Article body) {
        articleService.modifyArticle(body);
        return new Response(200, "Post article successfully.");
    }


    @ApiOperation(value = "获得用户首页分享", nickname = "articlesUserIdGet", notes = "", response = Article.class, responseContainer = "List", tags = {"article",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功找到首页分享", response = Article.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "用户不存在")})
    @RequestMapping(value = "/articles/{UserId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Response articlesUserIdGet(@ApiParam(value = "", required = true) @PathVariable("UserId") Integer userId) {
        articleService.getArticles(userId);
        return new Response(200, "Post article successfully.");
    }

}
