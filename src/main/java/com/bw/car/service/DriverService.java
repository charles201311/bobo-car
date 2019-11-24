package com.bw.car.service;

import com.bw.car.domain.Driver;

public interface DriverService {
	/**
	 * 司机注册
	 * @Title: insertSelective 
	 * @Description: TODO
	 * @param record
	 * @return
	 * @return: int
	 */
    int insertSelective(Driver record);

    /**
     *司机登录
     * @Title: login 
     * @Description: TODO
     * @param phone
     * @param password
     * @return
     * @return: Driver
     */
    Driver select(String phone, String password);

}
