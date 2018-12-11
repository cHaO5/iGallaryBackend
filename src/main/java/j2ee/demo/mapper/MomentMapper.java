package j2ee.demo.mapper;

import j2ee.demo.model.Moment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MomentMapper {
    @Select("SELECT * FROM moments")
    List<Moment> getALL();

    @Select("SELECT * FROM moments WHERE id = #{id}")
    Moment getOne(int id);

    @Insert("INSERT INTO moments(creator, content, likeNum, forwardNum, favouriteNum, commentNum)," +
            " VALUES(#{creator}, #{content}, #{likeNum}, #{forwardNum}, #{favouriteNum}, #{commentNum})")
    void insert(Moment moment);

    @Update("UPDATE users SET creator=#{creator}, content=#{content}, likeNum=#{likeNum}, " +
            "forwardNum=#{forwardNum}, favouriteNum=#{favouriteNum}, commentNum=#{commentNum} WHERE id =#{id}")
    void update(Moment moment);

    @Delete("DELETE FROM moments WHERE id =#{id}")
    void delete(int id);
}
