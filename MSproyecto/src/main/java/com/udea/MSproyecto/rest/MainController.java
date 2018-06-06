package com.udea.MSproyecto.rest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

	static final Logger log = Logger.getLogger(MainController.class);
	
	@RequestMapping("/index")
	@ResponseBody
	
	public String index(){
		
	return "Developed  by UdeA";
	}
	
	
}
