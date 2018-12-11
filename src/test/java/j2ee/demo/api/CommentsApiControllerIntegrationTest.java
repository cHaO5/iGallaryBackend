package j2ee.demo.controller;

import j2ee.demo.model.MomentComment;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsApiControllerIntegrationTest {

    @Autowired
    private CommentsApi api;

    @Test
    public void commentsCommentIdDeleteTest() throws Exception {
        Integer commentId = 56;
        ResponseEntity<Void> responseEntity = api.commentsCommentIdDelete(commentId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void commentsCommentIdGetTest() throws Exception {
        Integer commentId = 56;
        ResponseEntity<MomentComment> responseEntity = api.commentsCommentIdGet(commentId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void commentsCommentIdPutTest() throws Exception {
        MomentComment body = new MomentComment();
        Integer commentId = 56;
        ResponseEntity<MomentComment> responseEntity = api.commentsCommentIdPut(body, commentId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void commentsPostTest() throws Exception {
        MomentComment body = new MomentComment();
        ResponseEntity<MomentComment> responseEntity = api.commentsPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
