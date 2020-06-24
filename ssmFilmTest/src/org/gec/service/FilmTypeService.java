package org.gec.service;

import org.gec.pojo.Filmtype;

import java.util.List;

/**
 * @Description 电影类型实体类接口
 * @Author 余永浩
 * @Date 22:00 2020/6/20
**/
public interface FilmTypeService {

    //  1.查询电影类型
    List<Filmtype> findFilmTypeList();
}
