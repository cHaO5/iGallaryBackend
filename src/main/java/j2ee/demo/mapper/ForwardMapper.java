package j2ee.demo.mapper;

import j2ee.demo.model.Forward;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface ForwardMapper {
    @Results(id = "forwardMap", value = {
            @Result(property = "momentId", column = "moment_id")})
    @Select("SELECT * FROM forward")
    List<Forward> getALL();

    @Select("SELECT * FROM forward WHERE id = #{id}")
    Forward getOne(int id);

    @Insert("INSERT INTO forward(creator, moment_id) VALUES(#{creator}, #{momentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Forward forward);

    @Delete("DELETE FROM forward WHERE id = #{id}")
    void delete(int id);
}
