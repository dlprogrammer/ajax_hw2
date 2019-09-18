package com.dl.entity;

import java.io.Serializable;
import java.util.Objects;

public class Area implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String cityid;

    public Area() {
    }

    public Area(Integer id, String code, String name, String cityid) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cityid = cityid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(code, area.code) &&
                Objects.equals(name, area.name) &&
                Objects.equals(cityid, area.cityid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, cityid);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cityid='" + cityid + '\'' +
                '}';
    }
}
