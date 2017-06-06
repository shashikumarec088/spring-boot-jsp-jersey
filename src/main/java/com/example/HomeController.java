package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/abc")
	public String home(){
		return "forward:/jsp/home.jsp";
	}
}
