package org.gec.pojo;

import java.math.BigDecimal;

public class Filminfo {
    private Integer filmid;

    private String filmname;

    private Integer typeid;

    private String actor;

    private String director;

    private BigDecimal ticketprice;

    private String pic;

    private Filmtype filmType;

    public Filmtype getFilmType() {
        return filmType;
    }

    public void setFilmType(Filmtype filmType) {
        this.filmType = filmType;
    }

    public Integer getFilmid() {
        return filmid;
    }

    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname == null ? null : filmname.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public BigDecimal getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(BigDecimal ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    @Override
    public String toString() {
        return "Filminfo{" +
                "filmid=" + filmid +
                ", filmname='" + filmname + '\'' +
                ", typeid=" + typeid +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", ticketprice=" + ticketprice +
                ", pic='" + pic + '\'' +
                '}';
    }
}