package com.purandhar.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/server")
public class RunServerController {
	
	@GetMapping("/runserver")
	public String runServer() {
		
		return "Server Running";
	}

}
