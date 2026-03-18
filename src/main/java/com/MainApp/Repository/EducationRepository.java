package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MainApp.Entity.Education;

public interface EducationRepository extends MongoRepository<Education, String>
{

}
