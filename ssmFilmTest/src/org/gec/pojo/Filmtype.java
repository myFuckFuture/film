package org.gec.pojo;

import java.util.HashSet;
import java.util.Set;

public class Filmtype {
    private Integer typeid;

    private String typename;

    private Set<Filminfo> filmInfoSet =new HashSet<>();


    public Set<Filminfo> getFilmInfoSet() {
        return filmInfoSet;
    }

    public void setFilmInfoSet(Set<Filminfo> filmInfoSet) {
        this.filmInfoSet = filmInfoSet;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    @Override
    public String toString() {
        return "Filmtype{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}