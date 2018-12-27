package j2ee.demo.service.impl;

import j2ee.demo.mapper.ArticleMapper;
import j2ee.demo.model.Article;
import j2ee.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int deleteArticleById(Integer articleId) {
        return articleMapper.delete(articleId);
    }

    @Override
    public int deleteArticleLikes(Integer articleId, Integer userId) {

    }

    @Override
    public int addArticleLikes(Integer articleId, Integer userId) {

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
        return articleMapper.getALL();
    }
}
