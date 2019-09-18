package com.dl.entity;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String provinceid;

    public City() {
    }

    public City(Integer id, String code, String name, String provinceid) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinceid = provinceid;
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

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(code, city.code) &&
                Objects.equals(name, city.name) &&
                Objects.equals(provinceid, city.provinceid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, provinceid);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", provinceid='" + provinceid + '\'' +
                '}';
    }
}
