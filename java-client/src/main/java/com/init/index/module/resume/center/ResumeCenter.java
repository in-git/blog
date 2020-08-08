package com.init.index.module.resume.center;

import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RequestMapping("resume")
@RestController
@Slf4j
@Validated
public class ResumeCenter {
/*
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
                     暗号
    -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
* */

    @Autowired
    RedisUtil jedis;

    @RequestMapping("signal")
    public ResultInfo signal(@NotBlank String symbol) {
        String signal = jedis.get("signal");
        try {
            if (signal.equals(symbol)) {
                return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg());
            }
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_SELECT.getStatus(), eStatusSystem.ERROR_SELECT.getMsg());
        }
        return null;
    }



}
