package com.init.index.module.index.center;

import com.init.index.bean.Weblist;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.module.index.mapper.iWeblistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("index")
@CrossOrigin
@Validated
public class MainCenter {

    @Autowired
    iWeblistMapper navMapper;

    @Autowired
    RedisUtil jedis;

    /*======================================
                  返回Main模块所有信息
    ======================================*/
    @RequestMapping("weblist")
    @ResponseBody
    public ResultInfo weblist() {
        HashMap<Object, Object> info = new HashMap<>();
//      网页链接
        List<Weblist> weblists = navMapper.selectList(null);

//      个人理念
        ArrayList<String> motto = new ArrayList<>();
        motto.add(jedis.get("motto1"));
        motto.add(jedis.get("motto2"));
        motto.add(jedis.get("motto3"));

//      轮播图
        ArrayList<String> carousel = new ArrayList<>();
        carousel.add(jedis.get("carousel01"));
        carousel.add(jedis.get("carousel02"));
        carousel.add(jedis.get("carousel03"));


        info.put("weblists", weblists);
        info.put("motto", motto);
        info.put("carousel", carousel);

        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), info);
    }

    /*
        ======================================
                    返回Md5字符串
        ======================================
    * */
    @RequestMapping("md5")

    public ResultInfo md5(@NotBlank String original) {
        String result = DigestUtils.md5DigestAsHex(original.getBytes());
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), result);

    }

    /*
       ======================================
                   通知
       ======================================
   * */
    @RequestMapping("notice")
    public ResultInfo notice() {
        //        通知
        String OLD_MSG = "没有新通知";
        String notice = jedis.get("notice");
        if (StringUtils.isEmpty(notice)) {
            return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), OLD_MSG);
        }
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), notice);
    }

}
