package org.spring.springboot.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCityDao {

	@Autowired
	private CityDao cityDao;
	
	@Test
	public void testFindCityList() {
		List<City> citys = cityDao.selectCityList();
		System.out.println(citys.size());
	}
	
}
