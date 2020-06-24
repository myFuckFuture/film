package org.gec.query;

import java.math.BigDecimal;

/**
 * @Description 电影信息查询类
 * @Author 余永浩
 * @Date 16:47 2020/6/21
**/
public class FilmInfoQuery extends QueryObject{

    private String filmName;
    private Integer typeId;
    private String actor;
    private String director;
    private BigDecimal smallPrice;
    private BigDecimal bigPrice;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public BigDecimal getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(BigDecimal smallPrice) {
        this.smallPrice = smallPrice;
    }

    public BigDecimal getBigPrice() {
        return bigPrice;
    }

    public void setBigPrice(BigDecimal bigPrice) {
        this.bigPrice = bigPrice;
    }
}


