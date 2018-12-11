package j2ee.demo.controller;

import j2ee.demo.model.MomentComment;
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
public class CommentsApiController implements CommentsApi {

    private static final Logger log = LoggerFactory.getLogger(CommentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CommentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> commentsCommentIdDelete(@ApiParam(value = "",required=true) @PathVariable("CommentId") Integer commentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MomentComment> commentsCommentIdGet(@ApiParam(value = "",required=true) @PathVariable("CommentId") Integer commentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<MomentComment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MomentComment> commentsCommentIdPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MomentComment body,@ApiParam(value = "",required=true) @PathVariable("CommentId") Integer commentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<MomentComment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MomentComment> commentsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MomentComment body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<MomentComment>(HttpStatus.NOT_IMPLEMENTED);
    }

}
