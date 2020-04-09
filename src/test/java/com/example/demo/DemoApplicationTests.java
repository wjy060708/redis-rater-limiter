package com.example.demo;

import com.example.demo.service.TsetLuaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class DemoApplicationTests {

	@Autowired
	private TsetLuaService testLuaService;

	@Test
	void contextLoads() {
       testLuaService.exectLua();
	}
}
