package j2ee.demo.mapper;

import j2ee.demo.model.Article;
import j2ee.demo.model.MomentComment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MomentCommentMapper {
    @Results(id = "commentMap", value = {
            @Result(property = "momentId", column = "moment_id"),
            @Result(property = "senderId", column = "sender_id"),
            @Result(property = "quoteId", column = "quote_id"),
            @Result(property = "createTime", column = "create_time") })
    @Select("SELECT * FROM moment_comment")
    List<MomentComment> getALL();

    @ResultMap("commentMap")
    @Select("SELECT * FROM moment_comment WHERE id = #{id}")
    MomentComment getOne(int id);

    @Insert("INSERT INTO moment_comment(moment_id, sender_id, content, quote_id, create_time) " +
            "VALUES(#{momentId}, #{senderId}, #{content}, #{quoteId}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(MomentComment momentComment);

    @Update("UPDATE moment_comment SET moment_id = #{momentId}, sender_id = #{senderId}, content = #{content}, quote_id = #{quoteId}, " +
            "create_time = #{createTime} WHERE id = #{id}")
    int update(MomentComment momentComment);

    @Delete("DELETE FROM moment_comment WHERE id =#{id}")
    int delete(Integer id);
}
