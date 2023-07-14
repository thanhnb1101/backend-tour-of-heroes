package com.demo.heroes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.heroes.model.Hero;
import com.demo.heroes.service.HeroService;

@Controller
@RequestMapping(value = "/hero")
public class HeroController {
	static Logger log = LoggerFactory.getLogger(HeroController.class.getName());

	@Autowired
	HeroService heroService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> testService() {
		return new ResponseEntity<String>("Service is running...", HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Hero> createHero(@RequestBody Hero request) {
		Hero response = heroService.save(request);
		return new ResponseEntity<Hero>(response, HttpStatus.OK);
	}

}
