package org.gec.service.impl;

import org.gec.mapper.FilmtypeMapper;
import org.gec.pojo.Filmtype;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 电影类型实体类Service接口的实现类
 * @Author 余永浩
 * @Date 22:01 2020/6/20
**/
@Service
public class FilmTypeServiceImpl  implements FilmTypeService {

    //  引入资源
    @Autowired
    FilmtypeMapper filmTypeMapper;


    //  1.查询电影类型
    @Override
    public List<Filmtype> findFilmTypeList() {
        //  1.查询电影类型列表
        List<Filmtype> filmTypeList = filmTypeMapper.selectByExample(null);
        return filmTypeList;
    }
}
