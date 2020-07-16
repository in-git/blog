package com.init.index.module.user.center;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.global.utils.common.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 使用Redis作为数据库
 * */
@RequestMapping ( "user" )
@CrossOrigin
@RestController
public class HomeCenter {

    @Autowired
    RedisUtil jedis;

    //    对座右铭进行修改
    @RequestMapping ( "/updateMotto/{symbol}" )
    public ResultInfo updateMotto ( String text , @PathVariable ( "symbol" ) int symbol ) {
        try {
            switch ( symbol ) {
                case 1: {
                    jedis.set( "motto1" , text );
                    break;
                }
                case 2: {
                    jedis.set( "motto2" , text );
                    break;
                }
                case 3: {
                    jedis.set( "motto3" , text );
                    break;
                }
                default:
                    throw new IllegalStateException( "Unexpected value: " + symbol );

            }
            return new ResultInfo( eStatusSystem.SUCCESS_UPDATE.getStatus( ) , eStatusSystem.SUCCESS_UPDATE.getMsg( ) );
        }
        catch ( Exception ex ) {
            return new ResultInfo( eStatusSystem.ERROR_UPDATE.getStatus( ) , eStatusSystem.ERROR_UPDATE.getMsg( ) );
        }
    }

    //    对轮播图的图片进行修改
    @RequestMapping ( "/carouselUpdata" )

    public void carouselUpdata ( ) {

    }

    @Value ( "${win.path.img}" )
    public void setImgPath ( String imgPath ) {
        HomeCenter.imgPath = imgPath;
    }

    private static String imgPath;

    /*
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
       --------->    返回总消息
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
   */

    @RequestMapping ( "/message" )
    public ResultInfo message ( ) {
        //        返回座右铭
        ArrayList < String > motto = new ArrayList <>( );
        //        返回所有图片
        ArrayList < String > file = Tools.getFile( imgPath );
        HashMap < Object, Object > result = new HashMap <>( );
        motto.add( jedis.get( "motto1" ) );
        motto.add( jedis.get( "motto2" ) );
        motto.add( jedis.get( "motto3" ) );
        result.put( "motto" , motto );
        result.put( "view" , jedis.get( "view" ) );
        result.put( "fileList" , file );
        return new ResultInfo( eStatusSystem.SUCCESS_SELECT.getStatus( ) , eStatusSystem.SUCCESS_SELECT.getMsg( ) , result );
    }

}
