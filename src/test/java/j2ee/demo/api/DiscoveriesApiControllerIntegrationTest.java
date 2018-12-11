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
public class DiscoveriesApiControllerIntegrationTest {

    @Autowired
    private DiscoveriesApi api;

    @Test
    public void discoveriesUserIdGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<List<Moment>> responseEntity = api.discoveriesUserIdGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
