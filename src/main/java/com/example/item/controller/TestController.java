package com.example.item.controller;

import com.example.item.domain.dto.TestDTO;
import com.example.item.domain.entity.GoodsInfo;
import com.example.item.domain.repository.res.GoodsInfoRepository;
import com.example.item.service.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Setter(onMethod_ = @Autowired)
	private TestService testService;
	@Setter(onMethod_ = @Autowired)
	private GoodsInfoRepository goodsInfoRepository;

	@GetMapping(value = "/testAopMethod")
	public String testAopMethod() {
		testService.tests();
		return "hello";
	}

	@PostMapping(value = "/testControllerAdvice")
	public String testControllerAdvice(@RequestBody TestDTO testClass) {
		System.out.println(testClass.getTestCode());
		return "hello";
	}

	@GetMapping(value = "/testJpa")
	public String testJpa() {
		List<GoodsInfo> list =  goodsInfoRepository.findAll();
		return "hello";
	}
}
