package com.example.item;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test extends BaseTest{
	
	@Autowired
	private father father;
	
	@Test
	public void tests() {
		father.doJob();
	}
	
}
