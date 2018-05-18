package com.jealcazars.spring.helloworld.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jealcazars.spring.helloworld.domain.HelloWorldBean;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/spring-core-config.xml", "/spring-mvc-config.xml" })
public class HelloWorldServiceImplTest extends TestCase {

	@Autowired
	HelloWorldServiceImpl helloWorldServiceImpl;

	@Test
	public void testHello() throws Exception {

		HelloWorldBean bean = helloWorldServiceImpl.getHelloWorld("name");
		assertEquals("name", bean.getTitle());
	}

}
