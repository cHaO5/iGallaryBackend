package j2ee.demo.mapper;

import j2ee.demo.model.Moment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface MomentMapper {
    @Select("SELECT * FROM moment")
    List<Moment> getALL();

    @Select("SELECT * FROM moment WHERE id = #{id}")
    Moment getOne(int id);

    @Insert("INSERT INTO moment(creator, content, likeNum, forwardNum, favouriteNum, commentNum, tags)" +
            " VALUES(#{creator}, #{content}, #{likeNum}, #{forwardNum}, #{favouriteNum}, #{commentNum}, #{tags})")
    int insert(Moment moment);

    @Update("UPDATE moment SET creator=#{creator}, content=#{content}, likeNum=#{likeNum}, " +
            "forwardNum=#{forwardNum}, favouriteNum=#{favouriteNum}, commentNum=#{commentNum} , tags=#{tags} WHERE id =#{id}")
    int update(Moment moment);

    @Delete("DELETE FROM moment WHERE id =#{id}")
    int delete(int id);
}
