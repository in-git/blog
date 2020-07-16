package com.init.index.module.user.center;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.init.index.bean.Weblist;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusCommon;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.mapper.iWeblistMapper;
import com.init.index.module.user.mapper.iPermsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * 功能:
 *   1.用户管理中心
 *   2.开启shiro后，需要一定权限才能访问该类
 * */
@Controller
@Slf4j
@CrossOrigin
@RequestMapping ( "user" )
public class WeblistCenter {
    /*
     * 功能:对某项功能进行添加操作
     * */
    @Autowired
    iPermsMapper permsMapper;

    @Autowired
    iWeblistMapper weblistMapper;

    @ResponseBody
    @RequiresPermissions ( "admin:add" )
    @RequestMapping ( "add" )
    public ResultInfo add ( ) {
        Subject subject = SecurityUtils.getSubject( );
        String username = ( String ) subject.getPrincipal( );
        System.out.println( username );
        List < String > strings = permsMapper.selectPerms( username );
        return new ResultInfo( eStatusSystem.SUCCESS_INSERT.getStatus( ) , eStatusSystem.SUCCESS_INSERT.getMsg( ) , strings );
    }

/*
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    --------->    获取常用网页列表
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
*/

    @RequestMapping ( "/getWeblist" )
    @ResponseBody
    public List < Weblist > getWeblist ( ) {
        return weblistMapper.selectList( null );
    }

    /*
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    --------->    添加常用网页列表
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    */
    @ResponseBody
    @RequestMapping ( "/addWeblist" )
    public ResultInfo addWeblist (@Validated Weblist weblist ) {
        @NotNull String name = weblist.getName( );
        QueryWrapper < Weblist > wrapper = new QueryWrapper <>( );
        wrapper.eq( "name" , name );
        Weblist isExist = weblistMapper.selectOne( wrapper );
        if ( StringUtils.isEmpty( isExist ) ) {
            weblistMapper.insert( weblist );
            return new ResultInfo( eStatusSystem.SUCCESS_INSERT.getStatus( ) , eStatusSystem.SUCCESS_INSERT.getMsg( ) );
        }

        return new ResultInfo( eStatusSystem.ERROR_INSERT.getStatus( ) , eStatusSystem.ERROR_INSERT.getMsg( ) );
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    根据ID删除一个元素
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     */
    @RequestMapping ( "/deleteWeblistById/{id}" )
    @ResponseBody
    public ResultInfo deleteWeblistById ( @PathVariable ( "id" ) Integer id ) {
        int i = weblistMapper.deleteById( id );
        if ( i > 0 ) {
            return new ResultInfo( eStatusSystem.SUCCESS_DELETE.getStatus( ) , eStatusSystem.SUCCESS_DELETE.getMsg( ) );
        }
        return new ResultInfo( eStatusSystem.ERROR_DELETE.getStatus( ) , eStatusSystem.ERROR_DELETE.getMsg( ) );
    }

    /*
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
        --------->    更新元素
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    */
    @ResponseBody
    @RequestMapping ( "/updateWebList" )
    public ResultInfo updateWebList ( @Validated Weblist weblist ) {
        int integer = weblistMapper.updateWeblist( weblist );
        if ( 1 == integer ) {
            System.out.println( integer );
            return new ResultInfo( eStatusSystem.SUCCESS_UPDATE.getStatus( ) , eStatusSystem.SUCCESS_UPDATE.getMsg( ) );
        }

        return new ResultInfo( eStatusSystem.ERROR_UPDATE.getStatus( ) , eStatusSystem.ERROR_UPDATE.getMsg( ) );
    }
}
