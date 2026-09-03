package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MainApp.Entity.Footer;

public interface FooterRepository extends MongoRepository<Footer, String> {
}