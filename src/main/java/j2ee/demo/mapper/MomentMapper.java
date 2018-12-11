package j2ee.demo.mapper;

import j2ee.demo.model.Moment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MomentMapper {
    @Select("SELECT * FROM moment")
    List<Moment> getALL();

    @Select("SELECT * FROM moment WHERE id = #{id}")
    Moment getOne(int id);

    @Insert("INSERT INTO moment(creator, content, likeNum, forwardNum, favouriteNum, commentNum)," +
            " VALUES(#{creator}, #{content}, #{likeNum}, #{forwardNum}, #{favouriteNum}, #{commentNum})")
    void insert(Moment moment);

    @Update("UPDATE moment SET creator=#{creator}, content=#{content}, likeNum=#{likeNum}, " +
            "forwardNum=#{forwardNum}, favouriteNum=#{favouriteNum}, commentNum=#{commentNum} WHERE id =#{id}")
    void update(Moment moment);

    @Delete("DELETE FROM moment WHERE id =#{id}")
    void delete(int id);
}
