package j2ee.demo.mapper;

import j2ee.demo.model.UserFollow;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserFollowMapper {
    @Results(id = "userFollowMap", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "followTo", column = "follow_to") })
    @Select("SELECT * FROM user_follow")
    List<UserFollow> getALL();

    @ResultMap("userFollowMap")
    @Select("SELECT follow_to FROM user_follow WHERE user_id = #{userId}")
    List<Integer> followTo(int userId);

    @Insert("INSERT INTO user_follow(user_id, follow_to) VALUES(#{userId}, #{followTo})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(UserFollow userFollow);

    @Update("UPDATE user_follow SET user_id=#{userId}, follow_to=#{followTo} WHERE id =#{id}")
    int update(UserFollow userFollow);

    @Delete("DELETE FROM user_follow WHERE user_id=#{userId} AND follow_to=#{followTo}")
    int delete(int userId, int followTo);

    @ResultMap("userFollowMap")
    @Select("SELECT * FROM user_follow WHERE user_id = #{userId} AND follow_to = #{followTo}")
    public UserFollow findByUserIdAndFollowTo(@Param("userId") Integer userId, @Param("followTo") Integer followTo);
}
