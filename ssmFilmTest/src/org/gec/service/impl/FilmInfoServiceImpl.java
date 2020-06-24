package org.gec.service.impl;

import org.gec.mapper.FilminfoMapper;
import org.gec.pojo.Filminfo;
import org.gec.pojo.FilminfoExample;
import org.gec.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 电影信息类Service层接口的实现类
 * @Author 余永浩
 * @Date 17:04 2020/6/21
**/
@Service
public class FilmInfoServiceImpl implements FilmInfoService {

    //  引入资源
    @Autowired
    FilminfoMapper filmInfoMapper;

    //  1.分页查询电影信息列表
    @Override
    public List<Filminfo> findFilmInfoListByPage(FilminfoExample example) {
        List<Filminfo> filmInfoList=filmInfoMapper.findFilmInfoListByPage(example);
        return filmInfoList;
    }

    //  2.检查电影名
    @Override
    public boolean checkFilmName(String filmName) {
        List<Filminfo> filmInfoList = filmInfoMapper.findFilmInfoByFilmName(filmName);
        if(filmInfoList!=null && filmInfoList.size()>0){
            return true;
        }
        return false;
    }

    //  3.添加电影
    @Override
    public void addFilmInfo(Filminfo filmInfo) {
        filmInfoMapper.insert(filmInfo);
    }
}
