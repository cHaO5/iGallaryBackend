package j2ee.demo.mapper;

import j2ee.demo.model.Moment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface MomentMapper {
    @Results(id = "momentMap", value = {
            @Result(property = "likeNum", column = "like_num"),
            @Result(property = "forwardNum", column = "forward_num"),
            @Result(property = "favouriteNum", column = "favourite_num"),
            @Result(property = "commentNum", column = "comment_num") })
    @Select("SELECT * FROM moment")
    List<Moment> getALL();

    @ResultMap("momentMap")
    @Select("SELECT * FROM moment WHERE id = #{id}")
    Moment getOne(int id);

    @Insert("INSERT INTO moment(creator, content, like_num, forward_num, favourite_num, comment_num, tags, time, image)" +
            " VALUES(#{creator}, #{content}, #{likeNum}, #{forwardNum}, #{favouriteNum}, #{commentNum}, #{tags}, #{time}, #{image})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Moment moment);

    @Update("UPDATE moment SET creator=#{creator}, content=#{content}, like_num=#{likeNum}, " +
            "forward_num=#{forwardNum}, favourite_num=#{favouriteNum}, comment_num=#{commentNum}, tags=#{tags},  time=#{time}, image=#{image} WHERE id =#{id}")
    int update(Moment moment);

    @Delete("DELETE FROM moment WHERE id =#{id}")
    int delete(int id);
}
