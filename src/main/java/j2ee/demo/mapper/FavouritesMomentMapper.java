package j2ee.demo.mapper;

import j2ee.demo.model.FavouritesMoment;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface FavouritesMomentMapper {
    @Results(id = "favouritesMomentMap", value = {
            @Result(property = "momentId", column = "moment_id"),
            @Result(property = "favouritesId", column = "favourites_id") })
    @Select("SELECT * FROM favourites_moment")
    List<FavouritesMoment> getALL();

//    @ResultMap("favouritesMomentMap")
//    @Select("SELECT follow_to FROM favourites_moment WHERE favourites_id = #{favouritesId}")
//    List<Integer> followTo(int userId);

    @Insert("INSERT INTO favourites_moment(favourites_id, moment_id) VALUES(#{favouritesId}, #{momentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(FavouritesMoment favouritesMoment);

//    @Update("UPDATE favourites_moment SET favouritesId=#{favouritesId}, momentId=#{momentId} WHERE id =#{id}")
//    int update(FavouritesMoment favouritesMoment);

    @Delete("DELETE FROM favourites_moment WHERE favourites_id=#{favouritesId} AND moment_id=#{momentId}")
    int delete(int favouritesId, int momentId);

    @ResultMap("favouritesMomentMap")
    @Select("SELECT moment_id FROM favourites_moment WHERE favourites_id = #{favouritesId}")
    List<Integer> getMomentsInFavourites(Integer favId);
}
