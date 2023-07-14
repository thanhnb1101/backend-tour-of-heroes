package com.demo.heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.heroes.model.Hero;

@Repository("HeroRepository")
public interface HeroRepository  extends JpaRepository<Hero, Long>{

}
