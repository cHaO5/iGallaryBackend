package j2ee.demo.mapper;

import j2ee.demo.model.UserLikes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserLikesMapper {
    @Results(id = "userLikesMap", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "likesId", column = "likes_id")})
    @Select("SELECT * FROM user_likes")
    List<UserLikes> getALL();

//    @Select("SELECT followTo FROM user_likes WHERE userId = #{userId}")
//    List<Integer> followTo(int userId);

    @Insert("INSERT INTO user_likes(user_id, likes_id, type) VALUES(#{userId}, #{likesId}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(int userId, int likesId, String type);

//    @Update("UPDATE user_likes SET userId=#{userId}, likesId=#{likesId}, type=#{type} WHERE id =#{id}")
//    int update(UserLikes userLikes);

    @Delete("DELETE FROM user_likes WHERE user_id=#{userId} AND likes_id=#{likesId} AND type=#{type}")
    int delete(int userId, int likesId, String type);

    @ResultMap("userLikesMap")
    @Select("SELECT * FROM user_likes WHERE likes_id = #{likesId} AND user_id = #{userId} AND type='article'")
    UserLikes findByArticleIdAndUserId(Integer likesId, Integer userId);

    @ResultMap("userLikesMap")
    @Select("SELECT * FROM user_likes WHERE likes_id = #{likesId} AND user_id = #{userId} AND type='moment'")
    UserLikes findByMomentIdAndUserId(Integer likesId, Integer userId);
}
