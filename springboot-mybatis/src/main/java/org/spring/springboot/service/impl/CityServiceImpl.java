package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

	@Override
	public List<City> findCityList() {
		return cityDao.selectCityList();
	}
	
	public Page<City> getCityByPage(){
		City city = new City();
		PageHelper.startPage(1,2);
		Page<City> citys = cityDao.selectCityPage(city);
		return citys;
	}

}
