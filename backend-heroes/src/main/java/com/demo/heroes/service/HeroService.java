package com.demo.heroes.service;

import com.demo.heroes.model.Hero;

public interface HeroService {
	Hero save(Hero hero);
	
	Hero update(Hero hero) throws Exception;
	
	boolean delete (long id);
}
