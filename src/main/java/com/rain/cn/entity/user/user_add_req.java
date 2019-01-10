package com.rain.cn.entity.user;

import com.rain.cn.dao.generator.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by admin on 2019/1/7.
 */
public class user_add_req {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Integer mobile;
    @NotNull
    private String nickname;

    private String remark;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User toModel(){
        User user=new User();
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        user.setMobile(this.mobile);
        user.setNickname(this.getNickname());
        user.setStatuts(1);
        user.setRemark(this.getRemark());
        user.setCtime(new Date());
        return user;
    }


}
