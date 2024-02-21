package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MVC {
	@RequestMapping("/")
	public String helloMethod() {
		
		return "login";
		
	}
	@RequestMapping("getData")
	public String greetMethod(HttpServletRequest request) {
		String name=request.getParameter("uname");
		HttpSession sess=request.getSession();
		sess.setAttribute("abc",name);
		return "greet";
		
	}

}
