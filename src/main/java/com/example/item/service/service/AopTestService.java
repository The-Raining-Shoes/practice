package com.example.item.service.service;

import org.springframework.stereotype.Service;

import com.example.item.service.annation.AnnationTest;

@Service
public class AopTestService {
	
	@AnnationTest(testCode="测试数据")
	public void tests() {
		System.out.println("切面测试");
	}
}
