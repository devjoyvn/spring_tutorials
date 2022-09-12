package com.deft.lazy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LazyApplicationTests {

	@Autowired
	private Region region;

	@Test
	public void givenLazyAnnotation_whenAutowire_thenLazyBean() {
		City city = region.getCityInstance();
		System.out.println(city.getName());
	}

}
