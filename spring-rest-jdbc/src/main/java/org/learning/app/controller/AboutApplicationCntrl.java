package org.learning.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutApplicationCntrl {

	@Autowired
	private JdbcTemplate template;
	
	@GetMapping("/")
	public String aboutApplication(){
		return "Learn Spring 4.x using annotations";
	}
	
	@GetMapping("/db")
	public String checkDbHealth(){
		String health = null;
		if(template != null){
			health = "DB health is good!";
		}else{
			health = "DB not connected";
		}
		return health;
	}
}
