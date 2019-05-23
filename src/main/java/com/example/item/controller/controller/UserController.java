package com.example.item.controller.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.item.controller.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//注册页面
	@RequestMapping("/registIndex")
	public ModelAndView registIndex() {
		return new ModelAndView("/user/user_regist");
	}
	
	//登录页面
	@RequestMapping("/loginIndex")
	public ModelAndView loginIndex() {
		return new ModelAndView("/user/user_login");
	}

	//用户注册方法
	@RequestMapping("/registMethod")
	public ModelAndView registMethod(@RequestParam Map<String,String> param){
		Map<String,String> result = new HashMap<>();
		if(userService.userRegist(param)) {
			result.put("username", param.get("username"));
			return new ModelAndView("/home/index",result);
		}
		return new ModelAndView("/user/user_regist",result);
	}
	
	//用户登陆方法
	@RequestMapping("/loginMethod")
	public ModelAndView loginMethod(@RequestParam Map<String,String> param,HttpSession session){
		Map<String,String> result = new HashMap<>();
		if(userService.userLogin(param)) {
			result.put("username", param.get("username"));
			return new ModelAndView("/home/home_index",result);
		}
		return new ModelAndView("/user/user_login",result);
	}
	
	//ajax验证用户是否存在
	@RequestMapping("/ajaxNameCheck")
	@ResponseBody
	public Map<String,String> ajaxNameCheck (@RequestParam Map<String,String> param){
		System.out.println(param);
		Map<String,String> result = new HashMap<>();
		if(userService.nameCheck(param)) {
			result.put("result","该用户名已存在");
		}else {
			result.put("result","该用户名可以注册");
		}
		return result;
	}
	
	//ajax验证联系电话是否已注册
		@RequestMapping("/ajaxPhoneCheck")
		@ResponseBody
		public Map<String,String> ajaxPhoneCheck (@RequestParam Map<String,String> param){
			System.out.println(param);
			Map<String,String> result = new HashMap<>();
			if(userService.phoneCheck(param)) {
				result.put("result","该电话已被注册,请选择登陆");
			}else {
				result.put("result","该电话可以注册");
			}
			return result;
		}
	
	//完善信息方法
	@RequestMapping("/completeMethod")
	@ResponseBody
	public Map<String, String> completeMethod(@RequestParam("file") MultipartFile file,@RequestParam Map<String,String> param) {
		return userService.userComplete(file,param);
	}
	
	//完善信息页面
	@RequestMapping("/completePage")
	public ModelAndView completePage() {
		return new ModelAndView("/user/user_complete");
	}
	
}
