package com.rain.cn.dao.impl;

import com.rain.cn.dao.generator.mapper.UserMapper;
import com.rain.cn.dao.generator.model.User;
import com.rain.cn.dao.generator.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2019/1/7.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper mapper;

    public User getByToken(String token) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<User> lists = mapper.selectByExample(example);
        if(null == lists || lists.size() == 0)
            return null;
        return lists.get(0);
    }

}
