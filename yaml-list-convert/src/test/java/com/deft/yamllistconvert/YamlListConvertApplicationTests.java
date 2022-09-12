package com.deft.yamllistconvert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YamlListConvertApplicationTests {

	@Autowired ApplicationProps props;

	@Test
	void testLoad() {
		for(String item: props.getProfiles()) {
			System.out.println("Profile: " + item);
		}

		System.out.println("Name: " + props.getProps().get(0).get("name"));
		System.out.println("Port: " + props.getProps().get(1).get("port"));
		System.out.println("Username: " +props.getUsers().get(0).getUsername() );
	}

}
