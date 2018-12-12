package j2ee.demo.mapper;

import j2ee.demo.model.Picture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PictureMapper {
    @Select("SELECT * FROM picture")
    List<Picture> getALL();

    @Select("SELECT * FROM picture WHERE id = #{id}")
    Picture getOne(int id);

    @Insert("INSERT INTO picture(url), VALUES(#{url})")
    void insert(Picture picture);

    @Delete("DELETE FROM picture WHERE id =#{id}")
    void delete(String url);
}
