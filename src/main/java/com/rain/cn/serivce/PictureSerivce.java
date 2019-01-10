package com.rain.cn.serivce;

import com.rain.cn.dao.generator.model.Picture;

import java.util.List;

/**
 * Created by admin on 2019/1/10.
 */
public interface PictureSerivce {
    Picture get(Integer id);
    Picture getByPictureName(String name);
    Integer add(Picture picture);
    Integer update(Picture picture);
    Integer delete(Integer id);
    List<Picture> list(String name);
}
