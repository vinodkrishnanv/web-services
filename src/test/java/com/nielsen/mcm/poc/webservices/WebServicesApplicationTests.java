package com.nielsen.mcm.poc.webservices;

import com.nielsen.mcm.poc.webservices.rest.v1.controllers.MyAppController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebServicesApplicationTests {
	@Autowired
	private MyAppController controller;

	@Test
	void contextLoads() {
		assert(controller != null);
	}

	@Test
	void assertion() {
		assert(true == true);
	}

}
