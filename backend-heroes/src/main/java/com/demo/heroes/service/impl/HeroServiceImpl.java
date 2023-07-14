package com.demo.heroes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.heroes.model.Hero;
import com.demo.heroes.repository.HeroRepository;
import com.demo.heroes.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService{
	@Autowired
	HeroRepository heroRepository;

	@Override
	public Hero save(Hero hero) {
		return heroRepository.save(hero);
	}

}
