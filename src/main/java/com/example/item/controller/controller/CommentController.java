package com.example.item.controller.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.item.controller.service.CommentService;
import com.example.item.entity.entityInfo.UserInfo;
import com.example.item.repostory.index.UserInfoReportRepository;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired 
	private CommentService commentService;
	@Autowired
	private UserInfoReportRepository userInfoReportRepository;
	
	//查看帖子
		@RequestMapping("/commentView")
		@Transactional("resTransactionManager")
		public ModelAndView index(@RequestParam Map<String, Object> param) {
			System.out.println("123321123456231");
			UserInfo a = new UserInfo();
			a.setUserName("毛豪");
			a.setUserPassword("1233211");
			userInfoReportRepository.save(a);
			
			Map<String, Object> result = new HashMap<>();
			result = commentService.getElement();
			return new ModelAndView("ajax2",result);
		}
		
		//回复帖子
		@PostMapping("/commentAnswer")
		@ResponseBody
		public Map<String,Object> answer(@RequestParam Map<String, String> param) {
			Map<String,Object> result = new HashMap<>();
			result = commentService.getAnswer(param);
			return result;
		}
}
