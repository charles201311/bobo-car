package com.bw.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.car.dao.CarMapper;
import com.bw.car.domain.Car;
import com.bw.car.domain.Driver;
import com.bw.car.domain.DriverType;
import com.bw.car.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarMapper carMapper;

	@Override
	public PageInfo<Car> selects(Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		 List<Car> list = carMapper.selects();
		return new PageInfo<Car>(list);
	}

	@Override
	public int insert(Car record) {
		return carMapper.insert(record);
	}

	@Override
	public List<DriverType> selectTypes() {
		return carMapper.selectTypes();
		
	}

	@Override
	public PageInfo<Car> selectCarsByCode(Driver driver,Integer page,Integer pageSize) {
		//获取该驾驶员的驾驶证类型的所能包含的驾驶类型
		String include = driver.getDriverType().getInclude();
		String code=driver.getDriverType().getCode();//驾驶类型
		if(null!=include && !include.equals("")) {
			
			code+=","+include;
		}
		PageHelper.startPage(page, pageSize);
		List<Car> list = carMapper.selectCarsByCode(code.split(","));
		return  new PageInfo<Car>(list);
	}

}
