package com.init.index.module.index.mapper;

import com.init.index.bean.Github;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GithubMapper {
    //    查询
    @Select("select * from github limit 0 ,3")
    List<Github> selectLists();
}
