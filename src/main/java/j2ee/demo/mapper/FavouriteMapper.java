package j2ee.demo.mapper;

import j2ee.demo.model.Favourites;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavouriteMapper {
    @Select("SELECT * FROM favourites")
    List<Favourites> getALL();

    @Select("SELECT * FROM favourites WHERE id = #{id}")
    Favourites getOne(int id);

    @Insert("INSERT INTO favourites(creator, name), VALUES(#{creator}, #{name})")
    void insert(Favourites favourites);

    @Update("UPDATE users SET creator=#{creator}, name=#{name} WHERE id =#{id}")
    void update(Favourites favourites);

    @Delete("DELETE FROM favourites WHERE id =#{id}")
    void delete(int id);
}
