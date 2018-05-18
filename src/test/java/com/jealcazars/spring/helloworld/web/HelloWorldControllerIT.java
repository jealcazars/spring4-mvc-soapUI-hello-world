package com.jealcazars.spring.helloworld.web;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;

public class HelloWorldControllerIT {

	@Test
	public void testLog() {

		String baseUrl = System.getProperty("log.url");
		long nonce = (int) (Math.random() * 10000);
		System.out.println("Checking URL: " + baseUrl);

		RestAssured.baseURI = baseUrl;
		RestAssured.defaultParser = Parser.TEXT;
		String answer = get("/helloworld/rest/hello/" + nonce).asString();
		System.out.println("Response: " + answer);

		given().param("mimeType", "application/json").get("/" + nonce).then().assertThat()
				.body(containsString(nonce + ""));
	}
}
