package j2ee.demo.service.impl;

import j2ee.demo.mapper.ArticleMapper;
import j2ee.demo.mapper.UserLikesMapper;
import j2ee.demo.model.Article;
import j2ee.demo.model.UserLikes;
import j2ee.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    UserLikesMapper userLikesMapper;

    @Override
    public int deleteArticleById(Integer articleId) {
        return articleMapper.delete(articleId);
    }

    @Override
    public int deleteArticleLikes(Integer articleId, Integer userId) {
        userLikesMapper.delete(userId, articleId, "article");
        Article article = articleMapper.getOne(articleId);
        article.setLikeNum(article.getLikeNum() - 1);
        return articleMapper.update(article);
    }

    @Override
    public int addArticleLikes(Integer articleId, Integer userId) {
        userLikesMapper.insert(userId, articleId, "article");
        Article article = articleMapper.getOne(articleId);
        article.setLikeNum(article.getLikeNum() + 1);
        return articleMapper.update(article);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public int modifyArticle(Article article) {
        return articleMapper.update(article);
    }

    @Override
    public List<Article> getArticles(Integer userId) {
        return articleMapper.getAll();
    }

    @Override
    public Article findByArticleId(Integer articleId) { return articleMapper.getOne(articleId); }

    @Override
    public UserLikes findLikesByArticleIdAndUserId(Integer articleId, Integer userId) {
        return userLikesMapper.findByArticleIdAndUserId(articleId, userId);
    }
}
