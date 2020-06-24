package org.gec.service;

import org.gec.pojo.Filminfo;
import org.gec.pojo.FilminfoExample;

import java.util.List;

/**
 * @Description 电影信息类Service层接口
 * @Author 余永浩
 * @Date 17:03 2020/6/21
**/
public interface FilmInfoService {

    //  1.分页查询电影信息列表
    List<Filminfo> findFilmInfoListByPage(FilminfoExample example);

    //  2.检查电影名
    boolean checkFilmName(String filmName);

    //  3.添加电影
    void addFilmInfo(Filminfo filmInfo);
}
