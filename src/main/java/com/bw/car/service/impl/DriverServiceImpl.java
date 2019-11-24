package com.bw.car.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.car.dao.DriverMapper;
import com.bw.car.domain.Driver;
import com.bw.car.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Resource
	private DriverMapper driverMapper;

	@Override
	public int insertSelective(Driver record) {
           //这里省去了后台校验..比如注册用户重复,不能为空等.题目不要求可以不写
		return driverMapper.insertSelective(record);
	}

	@Override
	public Driver select(String phone, String password) {
		Driver driver = driverMapper.select(phone, password);
		if (null == driver)
			throw new RuntimeException("用户或密码不正确");
		return driver;
	}

}
