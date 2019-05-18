package com.ats.ATOS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/index")
	public String getwelcomePage() {
		return "index";
	}

}
