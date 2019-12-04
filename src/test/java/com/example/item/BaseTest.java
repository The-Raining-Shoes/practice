package com.example.item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={BaseTest.class})
public class BaseTest {
	
	@Test
	public void doJob() {
		System.out.println(123);
	}

}
