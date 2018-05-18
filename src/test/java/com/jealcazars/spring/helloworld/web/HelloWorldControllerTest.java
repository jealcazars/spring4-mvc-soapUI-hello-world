package com.jealcazars.spring.helloworld.web;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jealcazars.spring.helloworld.domain.HelloWorldBean;
import com.jealcazars.spring.helloworld.service.HelloWorldService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/spring-core-config.xml", "/spring-mvc-config.xml" })
public class HelloWorldControllerTest extends TestCase {

	@Mock
	HelloWorldService helloWorldService;

	@InjectMocks
	HelloWorldController helloWorldController;

	private MockMvc mockMvc;

	@Override
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
		when(helloWorldService.getHelloWorld(anyString())).thenReturn(new HelloWorldBean("mockMvcTest"));
	}

	@Test
	public void testHello() throws Exception {
		this.mockMvc.perform(get("/hello/name")).andDo(print()).andExpect(status().isOk());
	}
}