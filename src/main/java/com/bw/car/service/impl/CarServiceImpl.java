package com.bw.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.car.dao.CarMapper;
import com.bw.car.domain.Car;
import com.bw.car.domain.Driver;
import com.bw.car.domain.DriverType;
import com.bw.car.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarMapper carMapper;

	@Override
	public List<Car> selects() {
		return carMapper.selects();
	}

	@Override
	public int insert(Car record) {
		return carMapper.insert(record);
	}

	@Override
	public List<DriverType> selectTypes() {
		// TODO Auto-generated method stub
		return carMapper.selectTypes();
	}

	@Override
	public List<Car> selectCarsByCode(Driver driver) {
		//获取该驾驶员的驾驶证类型的所能包含的驾驶类型
		String include = driver.getDriverType().getInclude();
		String code="";//驾驶类型
		if(!include.equals("")) {
			code+=include+","+driver.getDriverType().getCode();
		}
		return carMapper.selectCarsByCode(code.split(","));
	}

}
