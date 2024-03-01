package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.ui.WebUIProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private WebUIProperties properties;

	@Test
	void contextLoads() {
		assertEquals("/ui", properties.getContextPath());
		assertEquals("user", properties.getDummyUserName());
		assertEquals("password", properties.getDummyUserPassword());
		assertTrue(properties.isDummyUserEnabled());
		assertTrue(properties.isLdapLoginEnabled());
	}

}
