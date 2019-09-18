package com.dl.service;

import com.dl.day1.AreaDAO;
import com.dl.day1.CityDAO;
import com.dl.day1.ProvinceDAO;
import com.dl.entity.Area;
import com.dl.entity.City;
import com.dl.entity.Province;
import com.dl.util.MyBatisUtil;

import java.util.List;

public class ShowServiceImpl implements ShowService {
    @Override
    public List<Province> showProvince() {
        ProvinceDAO provinceDAO = MyBatisUtil.getSqlSession().getMapper(ProvinceDAO.class);
        List<Province> provinces = provinceDAO.selectProvince();
        MyBatisUtil.close();
        return provinces;
    }

    @Override
    public List<City> showCity(City city) {
        CityDAO cityDAO = MyBatisUtil.getSqlSession().getMapper(CityDAO.class);
        List<City> cities = cityDAO.selectCity(city);
        MyBatisUtil.close();
        return cities;
    }

    @Override
    public List<Area> showArea(Area area) {
        AreaDAO areaDAO = MyBatisUtil.getSqlSession().getMapper(AreaDAO.class);
        List<Area> areas = areaDAO.selectArea(area);
        MyBatisUtil.close();
        return areas;
    }
}
