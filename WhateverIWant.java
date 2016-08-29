package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.dao.TeamDAO;
import demo.domain.Team;

@Controller
public class WhateverIWant {

	@Autowired
	
	TeamDAO teamDAO;

	@RequestMapping("/teams/{name}")
		public @ResponseBody Team hithere(@PathVariable String name) {
		
		System.out.println("in hi therereeeee");
		return teamDAO.findByName(name);
	}

	/*
	 * @RequestMapping("/hello/{name}") public String helloThere(Map model
	 * ,@PathVariable String nsame ) { model.put("name",name);
	 * System.out.println("name   " + name); //
	 * System.out.println("returningggggggdggggggggggggg hello"); return
	 * "hello"; }
	 * 
	 */

	/*
	 * @RequestMapping("/hi") public @ResponseBody String hiThere() {
	 * 
	 * 
	 * return "Hello"; }
	 */

}
