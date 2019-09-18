package com.dl.action;

import com.alibaba.fastjson.JSON;
import com.dl.entity.Area;
import com.dl.entity.City;
import com.dl.entity.Province;
import com.dl.service.ShowService;
import com.dl.service.ShowServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowAction {
    private Province province;
    private City city;
    private Area area;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    private ShowService showService = new ShowServiceImpl();

    public String showProvince() throws IOException {
        List<Province> provinces = showService.showProvince();
        String jsonString = JSON.toJSONString(provinces);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonString);
        return null;
    }

    public String showCity() throws IOException {
        List<City> cities = showService.showCity(city);
        String jsonString = JSON.toJSONString(cities);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonString);
        return null;
    }

    public String showArea() throws IOException {
        List<Area> areas = showService.showArea(area);
        String jsonString = JSON.toJSONString(areas);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonString);
        return null;
    }

}
