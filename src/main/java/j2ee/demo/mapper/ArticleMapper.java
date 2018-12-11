package j2ee.demo.mapper;

import j2ee.demo.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM articles")
    List<Article> getALL();

    @Select("SELECT * FROM articles WHERE id = #{id}")
    Article getOne(int id);
//
//    @Insert("INSERT INTO articles(title, content, likeNum, forwardNum, favouriteNum, commentNum) " +
//            "VALUES(#{userName}, #{passWord}, #{userSex})")
//    void insert(Article article);
//
//    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
//    void update(Article article);
//
//    @Delete("DELETE FROM users WHERE id =#{id}")
//    void delete(Long id);

}
