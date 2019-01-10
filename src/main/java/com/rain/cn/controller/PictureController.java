package com.rain.cn.controller;

import com.rain.cn.comon.CommResult;
import com.rain.cn.comon.RESULTMESSAGE;
import com.rain.cn.dao.generator.model.Picture;
import com.rain.cn.serivce.PictureSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2019/1/10.
 */
@RestController
@RequestMapping("/picture")

public class PictureController {
    @Autowired
    private PictureSerivce pictureSerivce;

    @GetMapping("/get")
    public CommResult get(Integer id){
        Picture user=pictureSerivce.get(id);
        return new CommResult(user);
    }
    @GetMapping("/list")
    public  CommResult list(String name){
        return new CommResult(pictureSerivce.list(name));
    }
    @PostMapping("/add")
    public CommResult add(@RequestBody Picture picture){
        pictureSerivce.add(picture);
        return new CommResult(RESULTMESSAGE.SUCCESS);
    }

}
