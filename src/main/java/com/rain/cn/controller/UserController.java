package com.rain.cn.controller;

import com.rain.cn.comon.CommResult;
import com.rain.cn.comon.RESULTMESSAGE;
import com.rain.cn.comon.RandomUtils;
import com.rain.cn.dao.generator.model.User;
import com.rain.cn.entity.user.user_add_req;
import com.rain.cn.entity.user.user_login_req;
import com.rain.cn.entity.user.user_login_res;
import com.rain.cn.serivce.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by admin on 2019/1/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @GetMapping("/get")
     public CommResult get(Integer id){
        return new CommResult( userSerivce.get(id));
    }

    @GetMapping("/list")
    public CommResult list(String name){
        return new CommResult(userSerivce.list(name));
    }

    @PostMapping("/add")
    public CommResult add(@RequestBody @Valid user_add_req req) {
        userSerivce.add(req.toModel());
        return new CommResult();
    }

    @PostMapping("/login")
    public CommResult login(@RequestBody @Valid user_login_req req) {
        User user = userSerivce.getByUserName(req.getUsername());
        if(null == user || user.getStatuts() != 1)
            return new CommResult(RESULTMESSAGE.USER_NOT_EXIST);

        if(!user.getPassword().equals(req.getPassword()))
            return new CommResult(RESULTMESSAGE.USER_PASSWORD_ERROR);
        //生成token
        User uduser = new User();
        uduser.setId(user.getId());
        uduser.setToken(RandomUtils.getUUIDString());
        uduser.setToken_vali(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); //token有效期12小时
        if(userSerivce.update(uduser) < 1)
            return new CommResult(RESULTMESSAGE.FAIL);
        user_login_res res = new user_login_res();
        res.setId(user.getId());
        res.setNickname(user.getNickname());
        res.setToken(uduser.getToken());
        return new CommResult(res);
    }

}
