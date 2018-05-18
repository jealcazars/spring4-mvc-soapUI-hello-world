package com.jealcazars.spring.helloworld.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jealcazars.spring.helloworld.domain.HelloWorldBean;
import com.jealcazars.spring.helloworld.service.HelloWorldService;

@RestController
@RequestMapping(value = "/rest", headers = "Accept=*/*")
public class HelloWorldRestController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldRestController.class);

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public HelloWorldBean hello(@PathVariable("name") String name) {
		logger.debug("hello--> {}", name);
		return helloWorldService.getHelloWorld(name);
	}

}