package com.bw.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.car.domain.Car;
import com.bw.car.domain.DriverType;
import com.bw.car.service.CarService;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @ClassName: CarController 
 * @Description: 管理员
 * @author: charles
 * @date: 2019年11月24日 下午2:16:52
 */

@Controller
public class CarController {
	
	@Resource
	private CarService carService;
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 去发布车辆
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add() {
		
		return "car_add";
		
	}
	
	
	

	
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 发布车辆
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@PostMapping("add")
	public boolean add(HttpServletRequest request,Car car,MultipartFile file) {
		if (!file.isEmpty()) {
			// 文件上传路径.把文件放入项目的 /resource/pic 下
			String path = request.getSession().getServletContext().getRealPath("/resource/pic/");
			// 为了防止文件重名.使用UUID 的方式重命名上传的文件
			String oldFilename = file.getOriginalFilename();
			// a.jpg
			String newFilename = UUID.randomUUID() + oldFilename.substring(oldFilename.lastIndexOf("."));
			File f = new File(path, newFilename);
			// 写入硬盘
			try {
				file.transferTo(f);

				car.setPicUrl(newFilename);// 标题图片
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		car.setCreated(new Date());//发布时间
		return carService.insert(car)>0;
		
	}
	
	/**
	 * 
	 * @Title: cars 
	 * @Description:查看已发布的车辆
	 * @return
	 * @return: String
	 */
	@GetMapping(value = {"","/","index"})
	public String cars(Model model,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "6")Integer pageSize) {
		 PageInfo<Car> info = carService.selects(page, pageSize);
		model.addAttribute("info", info);
		return "index";
		
	}
	
	
	/**
	 * 
	 * @Title: selectTypes 
	 * @Description: 查询所有的驾驶证类型
	 * @return
	 * @return: List<DriverType>
	 */
	@ResponseBody
	@GetMapping("selectTypes")
	public List<DriverType> selectTypes(){
		return carService.selectTypes();
	}
}
