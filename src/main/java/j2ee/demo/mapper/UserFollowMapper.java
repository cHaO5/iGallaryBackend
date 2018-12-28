package j2ee.demo.mapper;

import j2ee.demo.model.UserFollow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserFollowMapper {
    @Select("SELECT * FROM user_follow")
    List<UserFollow> getALL();

    // TODO 测试或者查资料select的列是否正确
    @Select("SELECT followTo FROM user_follow WHERE userId = #{userId}")
    List<Integer> followTo(int userId);

    @Insert("INSERT INTO user_follow(userId, followTo) VALUES(#{userId}, #{followTo})")
    int insert(UserFollow userFollow);

    @Update("UPDATE user_follow SET userId=#{userId}, followTo=#{followTo} WHERE id =#{id}")
    int update(UserFollow userFollow);

    @Delete("DELETE FROM user_follow WHERE userId=#{userId} AND followTo=#{followTo}")
    int delete(int userId, int followTo);
}
