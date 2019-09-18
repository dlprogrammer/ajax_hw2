package com.dl.day1;

import com.dl.entity.Area;

import java.util.List;

public interface AreaDAO {
    List<Area> selectArea(Area area);
}
