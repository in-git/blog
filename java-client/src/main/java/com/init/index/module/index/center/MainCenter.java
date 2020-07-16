package com.init.index.module.index.center;

import com.init.index.bean.Weblist;
import com.init.index.mapper.iNavMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MainCenter {

    @Autowired
    iNavMapper navMapper;
    /*
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
                    获取网页列表
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    * */
    @RequestMapping ( "/index/weblist" )
    public List < Weblist > weblist ( ) {
        return navMapper.selectList( null );
    }


}
