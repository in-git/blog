package com.init.index.module.user.center;

import com.init.index.bean.Github;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.global.utils.common.Tools;
import com.init.index.mapper.iGithubMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 使用Redis作为数据库
 * */
@RequestMapping("user")
@CrossOrigin
@Validated
@Slf4j
@RestController
public class HomeCenter {

    @Autowired
    RedisUtil jedis;

    //    对座右铭进行修改
    @RequestMapping("/updateMotto/{symbol}")
    public ResultInfo updateMotto(String text, @PathVariable("symbol") int symbol) {
        try {
            switch (symbol) {
                case 1: {
                    jedis.set("motto1", text);
                    break;
                }
                case 2: {
                    jedis.set("motto2", text);
                    break;
                }
                case 3: {
                    jedis.set("motto3", text);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + symbol);

            }
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_UPDATE.getStatus(), eStatusSystem.ERROR_UPDATE.getMsg());
        }
    }

    //    对轮播图的图片进行修改
    @RequestMapping("carouselUpdata")

    public ResultInfo carouselUpdata(String url, Integer symbol) {
        switch (symbol) {
            case 0: {
                jedis.set("carousel01", url);
                break;
            }
            case 1: {
                jedis.set("carousel02", url);
                break;
            }
            case 2: {
                jedis.set("carousel03", url);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + symbol);
        }
        return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
    }

    @Value("${path.img}")
    public void setImgPath(String imgPath) {
        HomeCenter.imgPath = imgPath;
    }

    private static String imgPath;

    /*
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
       --------->    返回总消息
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
   */

    @RequestMapping("/message")
    public ResultInfo message() {
        //        返回座右铭
        ArrayList<String> motto = new ArrayList<>();
        //        返回轮播图
        ArrayList<Object> carousel = new ArrayList<>();


        //        返回所有图片
        ArrayList<String> file = Tools.getFile(imgPath);
        HashMap<Object, Object> result = new HashMap<>();

        //        座右铭
        motto.add(jedis.get("motto1"));
        motto.add(jedis.get("motto2"));
        motto.add(jedis.get("motto3"));

//        通知
        String notice = jedis.get("notice");
        if (StringUtils.isEmpty(notice)) {
            notice = "没有新通知";
        }

        //返回轮播图
        carousel.add(jedis.get("carousel01"));
        carousel.add(jedis.get("carousel02"));
        carousel.add(jedis.get("carousel03"));

        result.put("motto", motto);
        result.put("view", jedis.scard("view"));
        result.put("fileList", file);
        result.put("notice", notice);
        result.put("carousel", carousel);
        result.put("signal", jedis.get("signal"));
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), result);
    }


    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    处理通知
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */
    @RequestMapping("setNotice")
    public ResultInfo setNotice(@NotBlank String notice) {
//          三天内是新通知
        try {
            jedis.setex("notice", notice, 60 * 60 * 12 * 3);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
        }

    }

    /*
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
       --------->    密钥设置
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
   */
    @RequestMapping("setSignal")
    public ResultInfo setSignal(@NotBlank String signal) {
//          三天内是新通知
        try {
            jedis.set("signal", signal);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
        }
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    Github查询
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */

    @Autowired
    iGithubMapper githubMapper;

    @RequestMapping("githubs")
    public List<Github> githubs() {
        try {
            List<Github> githubs = githubMapper.selectGihubs();
            return githubs;
        } catch (Exception ex) {
            log.warn(ex.toString());
            return null;
        }
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    Github添加
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */
    @RequestMapping("addGithub")
    public ResultInfo addGithub(@Validated Github github) {
        try {
            Integer count = githubMapper.selectCount();
            if (count < 3) {
                githubMapper.addGithub(github);
                return new ResultInfo(eStatusSystem.SUCCESS_INSERT.getStatus(), eStatusSystem.SUCCESS_INSERT.getMsg());
            }
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), "添加到达上限");

        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus(), eStatusSystem.ERROR_INSERT.getMsg());
        }

    }

    /*
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    --------->    Github删除
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
*/
    @RequestMapping("/deleteGithub/{id}")
    public ResultInfo deleteGithub(@PathVariable("id") Integer id) {
        try {
            githubMapper.deleteGithubById(id);
            return new ResultInfo(eStatusSystem.SUCCESS_DELETE.getStatus(), eStatusSystem.SUCCESS_DELETE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
        }
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    Github更新
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */

    @RequestMapping("/updateGithub")
    public ResultInfo updateGithub(Github github) {
        try{
            githubMapper.updateGithub(github);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        }
        catch(Exception ex){
            log.error(ex.toString());
            return new ResultInfo(eStatusSystem.ERROR_UPDATE.getStatus(), eStatusSystem.ERROR_UPDATE.getMsg());
        }
    }
}
