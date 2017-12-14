package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

import com.github.pagehelper.Page;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);

    /**
     * 查询城市列表
     * @return
     */
	List<City> selectCityList();

	/**
	 * 分页查询
	 * @param city
	 * @return
	 */
	Page<City> selectCityPage(City city);
	
}
