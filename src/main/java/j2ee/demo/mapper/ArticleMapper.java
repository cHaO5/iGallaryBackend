package j2ee.demo.mapper;

import j2ee.demo.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface ArticleMapper {
    String SELECT_FIELDS = " id, title, content, creator, like_num, forward_num, favourite_num, comment_num, time ";

    @Select({"SELECT", SELECT_FIELDS, "FROM article"})
    List<Article> getAll();

    @Select({"SELECT", SELECT_FIELDS, "FROM article WHERE id = #{id}"})
    Article getOne(int id);

    @Insert("INSERT INTO article(title, content, creator, like_num, forward_num, favourite_num, comment_num, time) " +
            "VALUES(#{title}, #{content}, #{creator}, #{likeNum}, #{forwardNum}, #{favouriteNum}, " +
            "#{commentNum}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Article article);

    @Update("UPDATE article SET title = #{title}, content = #{content}, creator = #{creator}, like_num = #{likeNum}, " +
            "forward_num = #{forwardNum}, favourite_num = #{favouriteNum}, comment_num = #{commentNum} WHERE id = #{id}")
    int update(Article article);

    @Delete("DELETE FROM article WHERE id =#{id}")
    int delete(Integer id);

//    @Select({"SELECT", SELECT_FIELDS, "FROM article WHERE user_id = #{userId}"})
//    List<Article> getArticlesByUserId(Integer userId);

//    @Select("SELECT * FROM article WHERE articleId = #{articleId} AND userId = #{userId}")
//    Article findByArticleIdAndUserId(Integer articleId, Integer userId);

}
