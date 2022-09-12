package com.deft;

import com.deft.animal.Cat;
import com.deft.animal.Dog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { CatConfig.class, DogConfig.class })
@ContextConfiguration(classes = { MammalConfiguration.class })
class ImportAnnotationApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void testBeanImport() {
		assertThatBeanExists("dog", Dog.class);
		assertThatBeanExists("cat", Cat.class);
	}

	private void assertThatBeanExists(String beanName, Class<?> beanClass) {
		Assertions.assertTrue(context.containsBean(beanName));
		Assertions.assertNotNull(context.getBean(beanClass));
	}
}
