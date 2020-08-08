package com.init.index.module.manager.mapper;

import com.init.index.bean.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    /*
     * 功能:修改管理员账号
     * */

    @Update("update users set username = #{username},passwd = #{passwd},black = #{black},restrictd = #{restrictd} where id = #{id}")
    public void updateUser(Users users);

    /*
     * 功能:获取账号密码
     * */
    @Select("select * from users")
    public List<Users> selectUsers();

    /*
     * 功能:删除账号
     * */
    @Delete("delete from users where id = #{id}")
    public void deleteUser(Integer id);
}
