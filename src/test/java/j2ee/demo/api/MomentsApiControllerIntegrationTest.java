package j2ee.demo.controller;

import j2ee.demo.model.Moment;

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
public class MomentsApiControllerIntegrationTest {

    @Autowired
    private MomentsApi api;

    @Test
    public void momentsMomentIdDeleteTest() throws Exception {
        Integer momentId = 56;
        ResponseEntity<Void> responseEntity = api.momentsMomentIdDelete(momentId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsMomentIdForwardUserIdPostTest() throws Exception {
        Integer momentId = 56;
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.momentsMomentIdForwardUserIdPost(momentId, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsMomentIdLikesUserIdDeleteTest() throws Exception {
        Integer momentId = 56;
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.momentsMomentIdLikesUserIdDelete(momentId, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsMomentIdLikesUserIdPostTest() throws Exception {
        Integer momentId = 56;
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.momentsMomentIdLikesUserIdPost(momentId, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsPostTest() throws Exception {
        Moment body = new Moment();
        ResponseEntity<Moment> responseEntity = api.momentsPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsPutTest() throws Exception {
        Moment body = new Moment();
        ResponseEntity<Moment> responseEntity = api.momentsPut(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void momentsUserIdGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<List<Moment>> responseEntity = api.momentsUserIdGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
