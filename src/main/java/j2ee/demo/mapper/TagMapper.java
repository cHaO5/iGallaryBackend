package j2ee.demo.mapper;

import j2ee.demo.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("SELECT * FROM pictures")
    List<Tag> getALL();

    @Select("SELECT * FROM pictures WHERE url = #{url}")
    Tag getOne(String url);

    @Insert("INSERT INTO pictures(url), VALUES(#{url})")
    void insert(Tag tag);

    @Delete("DELETE FROM pictures WHERE url =#{url}")
    void delete(String url);
}
