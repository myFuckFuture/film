package org.gec.mapper;

import org.apache.ibatis.annotations.Param;
import org.gec.pojo.Filminfo;
import org.gec.pojo.FilminfoExample;

import java.util.List;

public interface FilminfoMapper {
    int countByExample(FilminfoExample example);

    int deleteByExample(FilminfoExample example);

    int deleteByPrimaryKey(Integer filmid);

    int insert(Filminfo record);

    int insertSelective(Filminfo record);

    List<Filminfo> selectByExample(FilminfoExample example);

    Filminfo selectByPrimaryKey(Integer filmid);

    int updateByExampleSelective(@Param("record") Filminfo record, @Param("example") FilminfoExample example);

    int updateByExample(@Param("record") Filminfo record, @Param("example") FilminfoExample example);

    int updateByPrimaryKeySelective(Filminfo record);

    int updateByPrimaryKey(Filminfo record);

    //  1.分页查询电影信息列表，包含电影类型
    List<Filminfo> findFilmInfoListByPage(FilminfoExample example);

    //  2.通过电影姓名查询电影
    List<Filminfo> findFilmInfoByFilmName(String filmName);
}