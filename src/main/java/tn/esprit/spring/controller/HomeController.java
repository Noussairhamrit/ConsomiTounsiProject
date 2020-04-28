package tn.esprit.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/indexTemp.jsf")
	public String indexTemp(){
		return "indexTemp";
	}

}
