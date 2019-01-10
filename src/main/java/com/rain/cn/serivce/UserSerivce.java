package com.rain.cn.serivce;

import com.rain.cn.dao.generator.model.User;

import java.util.List;

/**
 * Created by admin on 2019/1/7.
 */
public interface UserSerivce {
    User get(Integer id);
    User getByUserName(String name);
    User getByToken(String token);
    Integer add(User user);
    Integer update(User user);
    Integer delete(Integer id);
    List<User> list(String name);
//    List<User> list(Integer id,String username,String password, Integer status, String mobile, String nickname);
}
