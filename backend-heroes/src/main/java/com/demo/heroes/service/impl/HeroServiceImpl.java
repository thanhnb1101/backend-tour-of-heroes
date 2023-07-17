package com.demo.heroes.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.heroes.common.CommonUtils;
import com.demo.heroes.controller.HeroController;
import com.demo.heroes.model.Hero;
import com.demo.heroes.repository.HeroRepository;
import com.demo.heroes.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService{
	static Logger log = LoggerFactory.getLogger(HeroService.class.getName());
	
	@Autowired
	HeroRepository heroRepository;

	@Override
	public Hero save(Hero hero) {
		return heroRepository.save(hero);
	}

	@Override
	public Hero update(Hero hero) throws Exception {
		Optional<Hero> checkExist = heroRepository.findById(hero.getId());
		if (checkExist == null) {
			throw new Exception("Can not find hero with id = " + hero.getId());
		} else {
			CommonUtils.copyNonNullProperties(hero, checkExist);
			return save(hero);
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<Hero> checkExist = heroRepository.findById(id);
		if (checkExist == null) {
			log.error("Can not find hero with id = " + id);
			return false;
		} else {
			heroRepository.deleteById(id);
			return true;
		}
	}

	@Override
	public List<Hero> list() {
		return heroRepository.findAll();
	}
	
	

}
