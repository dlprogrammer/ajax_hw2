package com.dl.service;

import com.dl.entity.Area;
import com.dl.entity.City;
import com.dl.entity.Province;

import java.util.List;

public interface ShowService {
    List<Province> showProvince();

    List<City> showCity(City city);

    List<Area> showArea(Area area);

}
