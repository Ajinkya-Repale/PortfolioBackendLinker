package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MainApp.Entity.Hero;

public interface HeroRepository extends MongoRepository<Hero, String>{

	
}
