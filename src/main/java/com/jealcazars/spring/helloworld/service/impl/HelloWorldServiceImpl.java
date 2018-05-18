package com.jealcazars.spring.helloworld.service.impl;

import org.springframework.stereotype.Service;

import com.jealcazars.spring.helloworld.domain.HelloWorldBean;
import com.jealcazars.spring.helloworld.service.HelloWorldService;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public HelloWorldBean getHelloWorld(String name) {
		return new HelloWorldBean(name);
	}

}