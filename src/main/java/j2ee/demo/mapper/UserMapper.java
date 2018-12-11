package j2ee.demo.mapper;

import j2ee.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getALL();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getOne(int id);

    @Insert("INSERT INTO users(password, description, avatar, email, username)," +
            " VALUES(#{password}, #{description}, #{avatar}, #{email}, #{username})")
    void insert(User user);

    @Update("UPDATE users SET password=#{password}, description=#{description}, avatar=#{avatar}, " +
            "email=#{email}, username=#{username} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(int id);
}
