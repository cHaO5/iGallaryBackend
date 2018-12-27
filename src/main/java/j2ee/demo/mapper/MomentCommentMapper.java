package j2ee.demo.mapper;

import j2ee.demo.model.Article;
import j2ee.demo.model.MomentComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MomentCommentMapper {
    @Select("SELECT * FROM moment_comment")
    List<MomentComment> getALL();

    @Select("SELECT * FROM moment_comment WHERE id = #{id}")
    MomentComment getOne(int id);

    @Insert("INSERT INTO moment_comment(momentId, senderId, content, quoteId, createTime) " +
            "VALUES(#{momentId}, #{senderId}, #{content}, #{quoteId}, #{createTime}, " +
            "#{commentNum})")
    int insert(MomentComment momentComment);

    @Update("UPDATE moment_comment SET momentId = #{momentId}, senderId = #{senderId}, content = #{content}, quoteId = #{quoteId}, " +
            "createTime = #{createTime} WHERE id = #{id}")
    int update(MomentComment momentComment);

    @Delete("DELETE FROM moment_comment WHERE id =#{id}")
    int delete(Integer id);
}
