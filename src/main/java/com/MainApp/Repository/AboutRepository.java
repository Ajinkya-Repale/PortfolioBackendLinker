package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Entity.About;

@Repository
public interface AboutRepository extends MongoRepository<About, String>{

}
