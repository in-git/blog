package com.init.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.index.bean.Weblist;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface iWeblistMapper extends BaseMapper < Weblist > {
    /*
         -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
         --------->    更新元素
         -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     */

    @Update ( value = "update weblist set icon = #{icon} ,"
            + "  `name` = #{name} ,"
            + " tips = #{tips} ,"
            + " tipsTitle = #{tipsTitle} , href = #{href}"
            + "where id = #{id}" )
    @Results()
    Integer updateWeblist ( Weblist weblist  );
}
