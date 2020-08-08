package com.init.index.module.website.center;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.index.bean.Message;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.global.utils.common.RandomName;
import com.init.index.global.utils.common.Tools;
import com.init.index.module.index.mapper.GithubMapper;
import com.init.index.module.website.mapper.WebsiteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.tools.Tool;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("website")
public class WebsiteCenter {
    /*
        =======================================
                   返回随机文本
        =======================================
    * */
    @Autowired
    RestTemplate restTemplate;
    private final static String URL_TEXT = "https://www.yunboys.cn/yan/api.php?charset=utf-8";

    @RequestMapping("randomText")
    public String randomText() {
        try {
            String text = restTemplate.getForObject(URL_TEXT, String.class);
            return text;
        } catch (Exception ex) {
            return null;
        }
    }
/*
    =======================================
               返回随机姓名
    =======================================
* */

    @RequestMapping("randomName")
    public String randomName() {
        String randomName = RandomName.getRandomName(true, 3);
        return randomName;
    }


    /*
        =======================================
                     添加留言
        =======================================
    * */

    @Autowired
    WebsiteMapper websiteMapper;

    private final static Integer SUCCESS = 1;

    @RequestMapping("addMessage")
    public ResultInfo addMessage(@Validated Message message) {
        int i = websiteMapper.addMessage(message);
        if (SUCCESS == i) {
            return new ResultInfo(eStatusSystem.SUCCESS_INSERT.getStatus(), eStatusSystem.SUCCESS_INSERT.getMsg());
        } else {
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
        }
    }

    /*
       =======================================
                        查询留言
       =======================================
   * */
    @RequestMapping("getMessages")
    public PageInfo getMessages(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<Message> messages = websiteMapper.selectMessages();

        return new PageInfo(messages);
    }

    /*
       =======================================
                        更新点赞
       =======================================
   * */
    @Autowired
    RedisUtil jedis;

    @RequestMapping("/addLove/{id}")
    public ResultInfo addLove(@PathVariable("id") Integer id) {

        try {
            String love = jedis.get("love");
            Integer integer = websiteMapper.selectLove(id);
            if (integer > Integer.valueOf(love)) {
                websiteMapper.updateVip(id);
            }
            websiteMapper.addLove(id);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_UPDATE.getStatus(), eStatusSystem.ERROR_UPDATE.getMsg());
        }
    }

     /*=======================================
                    查询所有Github
       =======================================*/

    @Autowired
    GithubMapper githubMapper;

    @RequestMapping("githubs")
    public ResultInfo githubs() {
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), githubMapper.selectLists());
    }

    /*=======================================
                    添加评分
       =======================================*/

    @RequestMapping("/setRate/{star}")
    public ResultInfo setRate(@PathVariable("star") String star, HttpServletRequest request) {
        String remoteAddr = Tools.getRemoteAddr(request);
        try {
            /*
            * 功能:添加评分
            * */
            if (!jedis.sismember("view", remoteAddr)) {
                jedis.hset("isStar", remoteAddr, "-1");
                jedis.sadd("rate", star);
                return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg());
            }
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
        }
        return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
    }

     /*
       功能:返回星星
       逻辑:
            1.如果存在IP，则禁用Button按钮
            2.查询Set集合中所有元素并返回平均分
   * */

    @RequestMapping("getInfo")
    public ResultInfo getInfo(HttpServletRequest request) {
        String remoteAddr = Tools.getRemoteAddr(request);
        Boolean isStar = jedis.sismember("view", remoteAddr);

        Set<String> rate = jedis.smembers("rate");
        Integer rates = 0;
        Iterator<String> iterator = rate.iterator();
        while (iterator.hasNext()) {
            String star = iterator.next();
            rates += Integer.valueOf(star);
        }
        int average = rates / rate.size();
        long view = Long.valueOf(jedis.scard("view"));

        HashMap<String, Object> info = new HashMap<>();
        info.put("isStar", isStar);
        info.put("averageStar", average);
        info.put("view", view);
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), info);
    }
}
