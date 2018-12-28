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

    @Insert("INSERT INTO users(password, description, avatar, email, username)" +
            " VALUES(#{password}, #{description}, #{avatar}, #{email}, #{username})")
    int insert(User user);

    @Update("UPDATE users SET password=#{password}, description=#{description}, avatar=#{avatar}, " +
            "email=#{email}, username=#{username} WHERE id =#{id}")
    int update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    int delete(int id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    List<User> findByUsername(String username);

    @Select("SELECT * FROM users WHERE email = #{email}")
    List<User> findByEmail(String email);
}
