package j2ee.demo.controller;

import j2ee.demo.model.Article;

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
public class ArticlesApiControllerIntegrationTest {

    @Autowired
    private ArticlesApi api;

    @Test
    public void articlesArticleIdDeleteTest() throws Exception {
        Integer articleId = 56;
        ResponseEntity<Void> responseEntity = api.articlesArticleIdDelete(articleId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void articlesArticleIdLikesUserIdDeleteTest() throws Exception {
        Integer articleId = 56;
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.articlesArticleIdLikesUserIdDelete(articleId, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void articlesArticleIdLikesUserIdPostTest() throws Exception {
        Integer articleId = 56;
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.articlesArticleIdLikesUserIdPost(articleId, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void articlesPostTest() throws Exception {
        Article body = new Article();
        ResponseEntity<Article> responseEntity = api.articlesPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void articlesPutTest() throws Exception {
        Article body = new Article();
        ResponseEntity<Article> responseEntity = api.articlesPut(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void articlesUserIdGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<List<Article>> responseEntity = api.articlesUserIdGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
