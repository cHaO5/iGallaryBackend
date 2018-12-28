package j2ee.demo.mapper;

import j2ee.demo.model.FavouritesMoment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface FavouritesMomentMapper {
    @Select("SELECT * FROM favourites_moment")
    List<FavouritesMoment> getALL();

    // TODO 测试或者查资料select的列是否正确
    @Select("SELECT followTo FROM favourites_moment WHERE favouritesId = #{favouritesId}")
    List<Integer> followTo(int userId);

    @Insert("INSERT INTO favourites_moment(favouritesId, momentId) VALUES(#{favouritesId}, #{momentId})")
    int insert(FavouritesMoment favouritesMoment);

//    @Update("UPDATE favourites_moment SET favouritesId=#{favouritesId}, momentId=#{momentId} WHERE id =#{id}")
//    int update(FavouritesMoment favouritesMoment);

    @Delete("DELETE FROM favourites_moment WHERE favouritesId=#{favouritesId} AND momentId=#{momentId}")
    int delete(int favouritesId, int momentId);

    @Select("SELECT momentId FROM favourites_moment WHERE favouritesId = #{favouritesId}")
    List<Integer> getMomentsInFavourites(Integer favId);
}
