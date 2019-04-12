package com.zsx.web.util;

import com.zsx.web.dao.UserMapper;
import com.zsx.web.entity.User;
import com.zsx.web.service.DemoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZSX on 2018/1/24.
 *
 * @author ZSX
 */
@Component
public class CacheUtil implements InitializingBean {


    public enum CacheEnum {
        user(),
        house();
    }

    @Autowired
    private UserMapper userMapper;

    public static List<User> users = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("开始初始化缓存");
        users = userMapper.selectAll();
    }

    public void refreshCache(CacheEnum cacheEnum) {
        System.out.println("刷新缓存:" + cacheEnum.toString());
        if (cacheEnum == CacheEnum.user) {
            List<User> userList = userMapper.selectAll();
            users = userList;
        }
    }
}
