package j2ee.demo.service;

import j2ee.demo.model.Article;
import j2ee.demo.model.UserLikes;

import java.util.List;

public interface ArticleService {

    int deleteArticleById(Integer articleId);

    int deleteArticleLikes(Integer articleId, Integer userId);

    int addArticleLikes(Integer articleId, Integer userId);

    int addArticle(Article article);

    int modifyArticle(Article article);

    List<Article> getArticles(Integer userId);

    Article findByArticleId(Integer articleId);

    UserLikes findLikesByArticleIdAndUserId(Integer articleId, Integer userId);
}
