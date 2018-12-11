package j2ee.demo.controller;

import j2ee.demo.model.Favourites;

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
public class FavouritesApiControllerIntegrationTest {

    @Autowired
    private FavouritesApi api;

    @Test
    public void favouritesUserIdDeleteTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<Favourites> responseEntity = api.favouritesUserIdDelete(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void favouritesUserIdPostTest() throws Exception {
        Favourites body = new Favourites();
        Integer userId = 56;
        ResponseEntity<Favourites> responseEntity = api.favouritesUserIdPost(body, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
