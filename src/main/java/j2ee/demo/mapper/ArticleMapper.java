package j2ee.demo.mapper;

import j2ee.demo.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM article")
    List<Article> getALL();

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getOne(int id);

    @Insert("INSERT INTO article(title, content, likeNum, forwardNum, favouriteNum, commentNum) " +
            "VALUES(#{title}, #{content}, #{creator}, #{likeNum}, #{forwardNum}, #{favouriteNum}, " +
            "#{commentNum})")
    void insert(Article article);

    @Update("UPDATE users SET title = #{title}, content = #{content}, creator = #{creator}, likeNum = #{likeNum}, " +
            "forwardNum = #{forwardNum}, favouriteNum = #{favouriteNum}, commentNum = #{commentNum} WHERE id = #{id}")
    void update(Article article);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
