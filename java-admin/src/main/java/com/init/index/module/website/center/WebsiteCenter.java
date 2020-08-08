package com.init.index.module.website.center;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.index.bean.Message;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.module.website.mapper.WebsiteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RequestMapping("/user/website")

@RestController
public class WebsiteCenter {

    @Autowired
    WebsiteMapper websiteMapper;
     /*
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
       --------->    返回所有留言
       -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
   */

    @RequestMapping("/messageList")
    public PageInfo messageList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Message> messages = websiteMapper.selectList();
        return new PageInfo(messages);
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    根据ID删除留言
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */
    @RequestMapping("/deleteMessage/{id}")
    public ResultInfo deleteMessage(@PathVariable("id") Integer id) {
        try {
            websiteMapper.deleteMessage(id);
            return new ResultInfo(eStatusSystem.SUCCESS_DELETE.getStatus(), eStatusSystem.SUCCESS_DELETE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
        }
    }

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    根据ID更新留言
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */
    @RequestMapping("/updateMessage")
    public ResultInfo updateMessageById(@Validated Message message) {
        log.warn(message.toString());
        try {
            websiteMapper.updateMessageById(message);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            log.warn(ex.toString());
            return new ResultInfo(eStatusSystem.ERROR_UPDATE.getStatus(), eStatusSystem.ERROR_UPDATE.getMsg());
        }
    }

    /*
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
        --------->    根据名字模糊查询
        -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
    */
    @RequestMapping("/searchMessage")
    public PageInfo searchMessageByName(String name) {
        PageHelper.startPage(1,10);
        List<Message> messages = websiteMapper.searchMessageByName(name);
        return new PageInfo(messages);
    }
}
