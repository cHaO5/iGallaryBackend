package j2ee.demo.controller;

import j2ee.demo.model.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Controller
public class ArticlesApiController implements ArticlesApi {

    private static final Logger log = LoggerFactory.getLogger(ArticlesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ArticlesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> articlesArticleIdDelete(@ApiParam(value = "",required=true) @PathVariable("ArticleId") Integer articleId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> articlesArticleIdLikesUserIdDelete(@ApiParam(value = "",required=true) @PathVariable("ArticleId") Integer articleId,@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> articlesArticleIdLikesUserIdPost(@ApiParam(value = "",required=true) @PathVariable("ArticleId") Integer articleId,@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Article> articlesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Article body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Article>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Article> articlesPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Article body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Article>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Article>> articlesUserIdGet(@ApiParam(value = "",required=true) @PathVariable("UserId") Integer userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Article>>(HttpStatus.NOT_IMPLEMENTED);
    }

}