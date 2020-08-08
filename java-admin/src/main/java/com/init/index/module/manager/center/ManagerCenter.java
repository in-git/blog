package com.init.index.module.manager.center;

import com.init.index.bean.Users;
import com.init.index.config.redis.RedisUtil;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.module.manager.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.io.*;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("manager")
@Validated
public class ManagerCenter {

    private final static String logPath = System.getProperty("user.dir").concat("/log/spring.log");

    @Autowired
    private RedisUtil jedis;

    @Autowired
    private ManagerMapper managerMapper;

    /*
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
     --------->    返回总消息
     -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
 */
    @RequestMapping("info")
    public ResultInfo managerInfo() {
        HashMap<String, Object> info = new HashMap<>();

        Set<String> ip = jedis.smembers("view");

        info.put("ip", ip);
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus(), eStatusSystem.SUCCESS_SELECT.getMsg(), info);
    }


    /*
     =============================
             删除单个IP
     =============================
 */
    @RequestMapping("deleteIp/{ip}")
    public ResultInfo deleteIp(@NotBlank @PathVariable("ip") String ip) {
        try {
            jedis.srem("view", ip);
            return new ResultInfo(eStatusSystem.SUCCESS_DELETE.getStatus(), eStatusSystem.SUCCESS_DELETE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
        }
    }


    /*
     =============================
          对管理员账号进行修改
     =============================
  */
    @RequestMapping("updateUser")
    public ResultInfo updateUser(Users users) {
        try {
            managerMapper.updateUser(users);
            return new ResultInfo(eStatusSystem.SUCCESS_UPDATE.getStatus(), eStatusSystem.SUCCESS_UPDATE.getMsg());
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ResultInfo(eStatusSystem.ERROR_UPDATE.getStatus(), eStatusSystem.ERROR_UPDATE.getMsg());
        }
    }

    /*
     =============================
              查询账号密码
     =============================
  */
    @RequestMapping("selectUsers")
    public List<Users> selectUsers() {
        return managerMapper.selectUsers();
    }

    /*
    =============================
               删除账户
    =============================
 */
    @RequestMapping("deleteUser/{id}")
    public ResultInfo deleteUser(@PathVariable("id") Integer id) {
        try {
            if (id == 1) {
                throw new IllegalArgumentException();
            }
            managerMapper.deleteUser(id);

            return new ResultInfo(eStatusSystem.SUCCESS_DELETE.getStatus(), eStatusSystem.SUCCESS_DELETE.getMsg());
        } catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
        }
    }

    /*
       =============================
                 a.读取日志
       =============================
*/
    @RequestMapping("getLog")
    public LinkedList<String> getLog() {

        File file = new File(logPath);
        LinkedList<String> logInfo = new LinkedList<>();
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(logPath);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    logInfo.add(br.readLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return logInfo;
    }

    /*
       =============================
                 a.清空日志
       =============================
*/
    @RequestMapping("clearLog")
    public ResultInfo clearLog() {
        File file = new File(logPath);
        if (file.exists()) {
            try {
                FileOutputStream os = new FileOutputStream(logPath);
                os.write(0);
                return new ResultInfo(eStatusSystem.SUCCESS_DELETE.getStatus(), eStatusSystem.SUCCESS_DELETE.getMsg());
            } catch (IOException e) {
                return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
            }
        }
        return new ResultInfo(eStatusSystem.ERROR_DELETE.getStatus(), eStatusSystem.ERROR_DELETE.getMsg());
    }
}
