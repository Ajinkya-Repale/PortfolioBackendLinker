package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Entity.Skills;

@Repository
public interface SkillsRepository extends MongoRepository<Skills, String>{

}