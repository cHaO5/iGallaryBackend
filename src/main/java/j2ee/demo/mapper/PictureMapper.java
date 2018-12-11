package j2ee.demo.mapper;

import j2ee.demo.model.Picture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PictureMapper {
    @Select("SELECT * FROM pictures")
    List<Picture> getALL();

    @Select("SELECT * FROM pictures WHERE url = #{url}")
    Picture getOne(String url);

    @Insert("INSERT INTO pictures(url), VALUES(#{url})")
    void insert(Picture picture);

    @Delete("DELETE FROM pictures WHERE url =#{url}")
    void delete(String url);
}
