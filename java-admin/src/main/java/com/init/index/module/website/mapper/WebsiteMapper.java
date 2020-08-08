package com.init.index.module.website.mapper;

import com.init.index.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WebsiteMapper {

    /*
     * 查询所有留言
     * */
    @Select("select * from message")
    List<Message> selectList();

    /*
     * 根据ID删除留言
     * */
    @Select("delete from message where id = #{id}")
    void deleteMessage(Integer id);

    /*
     * 根据ID更新
     * */
    @Update("update message set " +
            "id = #{ id },name = #{ name },content = #{ content },love = #{ love },isVip = #{ isVip },imgSrc = #{ imgSrc } " +
            "where id = #{id}")
    void updateMessageById(Message message);

    /*
     * 根据名字搜索
     * */

    @Select("  select * from message where name like concat('%', #{name}, '%')  ")
    List<Message> searchMessageByName( String name);
}
