package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.City;

import com.github.pagehelper.Page;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    /**
     * 查询城市列表
     * @return
     */
	List<City> findCityList();
	
	Page<City> getCityByPage();
}
