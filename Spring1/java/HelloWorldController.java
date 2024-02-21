package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	@RequestMapping("hello") //localhost:8082/hello
	public String helloMethod() {
		System.out.println("hello method!");
		return "hello.jsp";
	}
	@RequestMapping("greet") //localhost:8082/greet
	public String greetMethod() {
		System.out.println("greet method!");
		return "greet.jsp";
	}
	
}
