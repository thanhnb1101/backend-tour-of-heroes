package com.demo.heroes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.heroes.model.Hero;
import com.demo.heroes.service.HeroService;

@Controller
@RequestMapping(value = "")
public class HeroController {
	static Logger log = LoggerFactory.getLogger(HeroController.class.getName());

	@Autowired
	HeroService heroService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Service is running now.", HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Hero> createHero(@RequestBody Hero request) {
		Hero response = heroService.save(request);
		return new ResponseEntity<Hero>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Hero> updateHero(@RequestBody Hero request) {
		Hero response = heroService.save(request);
		return new ResponseEntity<Hero>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteHero(@RequestParam int id) {
		if (heroService.delete(id)) {
			return new ResponseEntity<String>("Delete successfully id: " + id, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Ops! There are something wrong with deletion id: " + id, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Hero>> list() {
		return new ResponseEntity<List<Hero>>(heroService.list(), HttpStatus.OK);
	}

}
