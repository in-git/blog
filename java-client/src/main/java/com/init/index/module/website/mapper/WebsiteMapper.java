package com.init.index.module.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.index.bean.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WebsiteMapper extends BaseMapper<Message> {

    //    添加留言
    @Insert("insert into message (imgSrc,name,content)values(#{imgSrc},#{name},#{content})")
    int addMessage(Message message);

    // 查询留言，并按照love排序
    @Select("select * from message order by love desc")
    List<Message> selectMessages();

//    添加点赞数
    @Select("update message set love = love + 1 where id = #{id} ")
    void addLove(Integer id);

//    查询点赞数
    @Select("select love from message where id = #{id}")
    Integer selectLove(Integer id);

//    更新SVIP状态
    @Update("update message set isVip = 1 where id = #{id}")
    void updateVip(Integer id);

}
