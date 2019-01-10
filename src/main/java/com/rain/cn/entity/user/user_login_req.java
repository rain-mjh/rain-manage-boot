package com.rain.cn.entity.user;


import javax.validation.constraints.NotNull;

/**
 * Created by admin on 2019/1/7.
 */

public class user_login_req {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

