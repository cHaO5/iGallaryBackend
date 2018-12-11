package j2ee.demo.mapper;

import j2ee.demo.model.Forward;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ForwardMapper {
    @Select("SELECT * FROM forwards")
    List<Forward> getALL();

    @Select("SELECT * FROM forwards WHERE creator = #{creator} and momentId = #{momentId}")
    Forward getOne(int creator, int momentId);

    @Insert("INSERT INTO forwards(creator, momentId), VALUES(#{creator}, #{momentId})")
    void insert(Forward forward);

    @Delete("DELETE FROM forwards WHERE creator = #{creator} and momentId = #{momentId}")
    void delete(int id);
}
