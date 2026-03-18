package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Entity.Projects;

@Repository
public interface ProjectRepo extends MongoRepository<Projects, String>{

}
