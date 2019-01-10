package com.rain.cn.serivce.impl;

import com.rain.cn.dao.generator.mapper.PictureMapper;
import com.rain.cn.dao.generator.model.Picture;
import com.rain.cn.dao.generator.model.PictureExample;
import com.rain.cn.serivce.PictureSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/1/10.
 */
@Service
public class DbPictureSerivce implements PictureSerivce {
    @Autowired
    private PictureMapper mapper;

    public Picture get(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public Picture getByPictureName(String name) {

        return null;
    }

    public Integer add(Picture picture) {
        return mapper.insertSelective(picture);
    }

    public Integer update(Picture picture) {
        return mapper.updateByPrimaryKeySelective(picture);
    }

    public Integer delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public List<Picture> list(String name) {
        PictureExample example=new PictureExample();
        return mapper.selectByExample(example);
    }
}
