package com.bw.car.service;

import java.util.List;

import com.bw.car.domain.Car;
import com.bw.car.domain.Driver;
import com.bw.car.domain.DriverType;
import com.github.pagehelper.PageInfo;

public interface CarService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 发布车辆(管理员增加车辆)
	 * @param record
	 * @return
	 * @return: int
	 */
    int insert(Car record);
    
    /**
	 * 
	 * @Title: selects 
	 * @Description: 管理员查询.
	 * @return
	 * @return: List<Car>
	 */
	PageInfo<Car> selects(Integer page,Integer pageSize);

	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据驾驶证类型 查询所有的汽车.
	 * @return
	 * @return: List<Car>
	 */
	PageInfo<Car> selectCarsByCode(Driver driver,Integer page,Integer pageSize);
	
	   /**
     * 
     * @Title: selectTypes 
     * @Description: 查询所有的驾驶证类
     * @return
     * @return: List<DriverType>
     */
    List<DriverType> selectTypes();
}
