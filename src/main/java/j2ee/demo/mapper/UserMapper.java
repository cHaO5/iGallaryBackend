package j2ee.demo.mapper;

import j2ee.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getALL();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getOne(int id);

    @Insert("INSERT INTO users(password, description, avatar, email, username, salt)" +
            " VALUES(#{password}, #{description}, #{avatar}, #{email}, #{username}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    @Update("UPDATE users SET password=#{password}, description=#{description}, avatar=#{avatar}, " +
            "email=#{email}, username=#{username} WHERE id =#{id}")
    int update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    int delete(int id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail(String email);

    @Update("UPDATE users SET password=#{password} WHERE email =#{email}")
    int modifyByEmail(User user);
}
