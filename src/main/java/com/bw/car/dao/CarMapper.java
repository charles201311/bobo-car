package com.bw.car.dao;

import java.util.List;

import com.bw.car.domain.Car;
import com.bw.car.domain.DriverType;

public interface CarMapper {

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
     * 根据驾驶证的类型查询可以驾驶的车辆
     * @Title: selectByTypeCode 
     * @Description: TODO
     * @param code
     * @return
     * @return: List<Car>
     */
    List<Car> selectCarsByCode(String[] code);
    
    /**
     * 
     * @Title: selects 
     * @Description: 管理员查询
     * @return
     * @return: List<Car>
     */
	public List<Car> selects();
    
    /**
     * 
     * @Title: selectTypes 
     * @Description: 查询所有的驾驶证类
     * @return
     * @return: List<DriverType>
     */
    List<DriverType> selectTypes();

}