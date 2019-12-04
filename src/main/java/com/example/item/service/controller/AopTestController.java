package com.example.item.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.service.service.AopTestService;

@RestController
@RequestMapping(value = "/aop")
public class AopTestController {
	
	@Autowired
	private AopTestService aopTestService;
	
	@GetMapping(value = "/testAopMethod")
	public String testAopMethod() {
		aopTestService.tests();
		return "hello";
	}
}
