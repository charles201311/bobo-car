package com.bw.car.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bw.car.domain.Driver;
import com.bw.car.service.DriverService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@Controller
public class PassportController {
	@Resource
	private DriverService driverService;

	/**
	 * 
	 * @Title: login
	 * @Description:去 登录
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 
	 * @Title: login
	 * @Description: 登录
	 * @param
	 * @return
	 * @return: String
	 */
	@PostMapping("login")
	public String login(Model model, Driver driver, String phone, String password, HttpSession session) {

		try {
			Driver d = driverService.select(phone, password);// 没有异常则登录成功
			// 存session
			session.setAttribute("driver", d);
			
			return "redirect:/driver/cars";//重定向到租车列表页面

		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());

		}

		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "系统异常");

		}

		return "login";

	}

	/**
	 * 
	 * @Title: reg
	 * @Description: 去注册
	 * @return
	 * @return: String
	 */

	@GetMapping("reg")
	public String reg() {
		return "reg";
	}

	
	/**
	 * 
	 * @Title: reg 
	 * @Description: 注册
	 * @param model
	 * @param driver
	 * @param redirectAttributes
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("reg")
	public boolean reg(Model model, Driver driver) {

		return driverService.insertSelective(driver)>0;//

	}
}
