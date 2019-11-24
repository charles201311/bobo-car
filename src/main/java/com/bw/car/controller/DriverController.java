package com.bw.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.car.domain.Car;
import com.bw.car.domain.Driver;
import com.bw.car.service.CarService;
/**
 * 
 * @ClassName: DriverController 
 * @Description: 注册的驾驶员
 * @author: charles
 * @date: 2019年11月24日 下午2:10:20
 */
@RequestMapping("driver")
@Controller
public class DriverController {
	
	@Resource
	private CarService carService;
	
	/**
	 * 注册的驾驶员,能租什么类型的车的列表
	 * @Title: cars 
	 * @Description: TODO
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("cars")
	public String cars(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//从session获取登录到驾驶员
		Driver driver = (Driver) session.getAttribute("driver");
			//查看注册用户能租什么类型的车.跳转到列表
		List<Car> cars = carService.selectCarsByCode(driver);
		request.setAttribute("cars", cars);
		return "cars";
		
	}

}
