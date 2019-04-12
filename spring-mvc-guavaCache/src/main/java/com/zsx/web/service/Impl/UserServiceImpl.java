package com.zsx.web.service.Impl;

import com.zsx.web.config.MyAnno;
import com.zsx.web.dao.UserMapper;
import com.zsx.web.entity.User;
import com.zsx.web.service.DemoService;
import com.zsx.web.service.UserService;
import com.zsx.web.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
//    @Cacheable(value = "cacheName", key = "'id'")
    public User searchById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @MyAnno(CacheUtil.CacheEnum.user)
    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

//	@Transactional
//	public int update(User user) {
//		return userMapper.updateByPrimaryKey(user);
//	}

    @Override
    @Transactional
    public int delete(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getAllFromCache() {
        return CacheUtil.users;
    }
}