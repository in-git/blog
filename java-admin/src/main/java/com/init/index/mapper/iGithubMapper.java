package com.init.index.mapper;


import com.init.index.bean.Github;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface iGithubMapper {
//    添加Github
    @Insert("insert into github (title,description,img,download,address,url)" +
            "values(#{ title },#{ description },#{ img },#{  download },#{ address },#{ url })")
    void addGithub(Github github);

//    查询所有
    @Select("select * from github limit 0 , 3")
    List<Github> selectGihubs();

//    查询数量，超过三条不再添加
    @Select("select count(id) from github")
    Integer selectCount();

//    通过ID删除
    @Delete("delete from github where id = #{id}")
     void deleteGithubById(Integer id);

//    更新
    @Update("update github set title = #{title} , description = #{ description },img = #{ img } , download = #{ download } ,address = #{ address },url = #{ url } where id = #{id}")
    void updateGithub(Github github);
}
