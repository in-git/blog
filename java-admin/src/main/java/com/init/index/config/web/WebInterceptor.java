package com.init.index.config.web;

import com.init.index.config.plugin.SpringContextUtil;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.utils.common.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {

    /*
     * 功能:截取用户请求，统计用户访问量
     * */



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userIp = Tools.getRemoteAddr(request);
        RedisUtil jedis = SpringContextUtil.getBean(RedisUtil.class);
        if (jedis.type("view").equals("set")) {
            jedis.sadd("view", userIp);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
