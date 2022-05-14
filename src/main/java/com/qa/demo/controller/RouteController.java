package com.qa.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

	@GetMapping("/home")
	public String homePage() {
		return "index.html";
	}

	@GetMapping("/jay")
	public String jayPage() {
		return "jay.html";
	}

}
