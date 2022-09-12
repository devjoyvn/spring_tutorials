package com.deft.applicationcontext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationContextApplicationTests {

	@Autowired
	private ApplicationContextService applicationContextService;

	@Test
	void contextLoads() {
		Assertions.assertEquals(applicationContextService.getMyBeanName(), "My Bean");
	}

}
