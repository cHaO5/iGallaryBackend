package j2ee.demo.mapper;

import j2ee.demo.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("SELECT * FROM tag")
    List<Tag> getALL();

    @Select("SELECT * FROM tag WHERE id = #{id}")
    Tag getOne(String url);

    @Insert("INSERT INTO tag(tagname) VALUES(#{tagname})")
    void insert(String tagname);

    @Delete("DELETE FROM pictures WHERE id =#{id}")
    void delete(int id);
}
