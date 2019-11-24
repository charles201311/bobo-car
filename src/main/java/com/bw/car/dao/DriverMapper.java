package com.bw.car.dao;

import org.apache.ibatis.annotations.Param;

import com.bw.car.domain.Driver;

public interface DriverMapper {

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
    Driver select(@Param("phone") String phone,@Param("password") String password);

    
    
   
}