package j2ee.demo.controller;

import j2ee.demo.model.Favourites;
import j2ee.demo.model.User;

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
public class UsersApiControllerIntegrationTest {

    @Autowired
    private UsersApi api;

    @Test
    public void usersPostTest() throws Exception {
        User body = new User();
        ResponseEntity<User> responseEntity = api.usersPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdFavouritesFavIdGetTest() throws Exception {
        Integer userId = 56;
        Integer favId = 56;
        ResponseEntity<Favourites> responseEntity = api.usersUserIdFavouritesFavIdGet(userId, favId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdFollowsFollowedUserIdDeleteTest() throws Exception {
        Integer userId = 56;
        Integer followedUserId = 56;
        ResponseEntity<Void> responseEntity = api.usersUserIdFollowsFollowedUserIdDelete(userId, followedUserId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdFollowsFollowedUserIdPostTest() throws Exception {
        Integer userId = 56;
        Integer followedUserId = 56;
        ResponseEntity<Void> responseEntity = api.usersUserIdFollowsFollowedUserIdPost(userId, followedUserId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdFollowsGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<List<User>> responseEntity = api.usersUserIdFollowsGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<User> responseEntity = api.usersUserIdGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void usersUserIdPutTest() throws Exception {
        User body = new User();
        Integer userId = 56;
        ResponseEntity<User> responseEntity = api.usersUserIdPut(body, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
