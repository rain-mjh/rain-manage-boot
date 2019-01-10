package com.rain.cn.serivce.impl;

import com.rain.cn.dao.generator.mapper.UserMapper;
import com.rain.cn.dao.generator.model.User;
import com.rain.cn.dao.generator.model.UserExample;
import com.rain.cn.dao.impl.UserDao;
import com.rain.cn.serivce.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/1/7.
 */
@Service
public class DbUserSerivce implements UserSerivce {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserDao userDAO;

    public User get(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public User getByUserName(String username) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> lists=mapper.selectByExample(example);
        if(null == lists || lists.size() == 0){
            return null;
        }

        return lists.get(0);
    }

    public User getByToken(String token) {
        return userDAO.getByToken(token);
    }

    public Integer add(User user) {
        return mapper.insertSelective(user);
    }

    public Integer update(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }

    public Integer delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public List<User> list(String name) {
        UserExample example=new UserExample();
        return mapper.selectByExample(example);
    }

//    public List<User> list(Integer id, String username, String password, Integer status, String mobile, String nickname) {
//        UserExample example=new UserExample();
//        return mapper.selectByExample(example);
//    }
}
