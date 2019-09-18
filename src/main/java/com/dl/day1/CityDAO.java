package com.dl.day1;

import com.dl.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> selectCity(City city);
}
