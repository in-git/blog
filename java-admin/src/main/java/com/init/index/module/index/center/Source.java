package com.init.index.module.index.center;

import com.init.index.config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping ( "public" )
public class Source {
    /*
     * 类功能:该类主要负责主页资源管理
     * 方案:由于图片资源具有非关系特性，采用nosql-Redis实现
     * */
    @Autowired
    RedisUtil jedis;

    @RequestMapping ( "resource" )
    public String resource ( ) {
        //        首页banner
        return null;
    }

}
