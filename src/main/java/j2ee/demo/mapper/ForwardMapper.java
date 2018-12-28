package j2ee.demo.mapper;

import j2ee.demo.model.Forward;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface ForwardMapper {
    @Select("SELECT * FROM forward")
    List<Forward> getALL();

    @Select("SELECT * FROM forward WHERE id = #{id}")
    Forward getOne(int id);

    @Insert("INSERT INTO forward(creator, momentId) VALUES(#{creator}, #{momentId})")
    int insert(Forward forward);

    @Delete("DELETE FROM forward WHERE id = #{id}")
    void delete(int id);
}
