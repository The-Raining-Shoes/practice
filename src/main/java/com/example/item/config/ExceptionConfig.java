//package com.example.item.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice
//public class ExceptionConfig {
//	
//	public static final String ERROR_VIEW = "error";
//	
//	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
//	public Object errorHandler(HttpServletRequest request,HttpServletResponse response,Exception e) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception",e);
//		mav.addObject("url",request.getRequestURI());
//		mav.setViewName(ERROR_VIEW);
//		return mav;
//	}
//	
//}
