package com.jealcazars.spring.helloworld.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jealcazars.spring.helloworld.service.HelloWorldService;

@Controller
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
		logger.debug("hello--> {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("helloBean", helloWorldService.getHelloWorld(name));
		return model;
	}

}