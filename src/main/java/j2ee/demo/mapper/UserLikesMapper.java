package j2ee.demo.mapper;

import j2ee.demo.model.UserLikes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserLikesMapper {
    @Select("SELECT * FROM user_likes")
    List<UserLikes> getALL();

    // TODO 测试或者查资料select的列是否正确
//    @Select("SELECT followTo FROM user_likes WHERE userId = #{userId}")
//    List<Integer> followTo(int userId);

    @Insert("INSERT INTO user_likes(userId, likesId, type) VALUES(#{userId}, #{likesId}, #{type})")
    int insert(int userId, int likesId, String type);

//    @Update("UPDATE user_likes SET userId=#{userId}, likesId=#{likesId}, type=#{type} WHERE id =#{id}")
//    int update(UserLikes userLikes);

    @Delete("DELETE FROM user_likes WHERE userId=#{userId} AND likesId=#{likesId} AND type=#{type}")
    int delete(int userId, int likesId, String type);
}
